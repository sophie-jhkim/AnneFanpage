package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//여기서 이렇게 필터링 인코딩을 주면 다른데서 utf-8을 적용해줄 필요가 없다
@WebFilter(
		urlPatterns="/*",
		initParams= {
				@WebInitParam(name="encoding", value="UTF-8")
		})
public class CharacterEncodingFilter implements Filter{
FilterConfig config;
	
	@Override
	public void init(FilterConfig config) throws ServletException{
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
			throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		nextFilter.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {}
	

}
