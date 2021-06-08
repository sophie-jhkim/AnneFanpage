package control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
		String servletPath = request.getServletPath();
		
		try {
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", request.getSession());
			Controller controller = (Controller) ctx.getBean(servletPath); 
			System.out.println(controller);
			
			if(controller instanceof DataBinding) {
				prepareRequestData(request, model, (DataBinding)controller);
			}
			
			
			
			String viewUrl = controller.execute(model);
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
				System.out.println("key : "+ key);
			}

			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding)
		throws Exception{
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for(int i=0; i<dataBinders.length; i+=2) {
			dataName = (String) dataBinders[i];
			dataType = (Class<?>) dataBinders[i+1];
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			model.put(dataName, dataObj);
		}
		
	}
	

}
