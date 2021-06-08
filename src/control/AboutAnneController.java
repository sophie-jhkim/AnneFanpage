package control;

import java.util.Map;
@Component("/AnneAdmin/Anne.do")
public class AboutAnneController implements Controller{

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "../AnneAdmin/Anne.jsp";
	}

}
