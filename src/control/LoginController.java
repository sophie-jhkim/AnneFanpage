package control;

import java.util.Map;
import javax.servlet.http.HttpSession;
import dao.ManiaDao;
import dto.Mania;

@Component("/AnneCustom/login.do")
public class LoginController implements Controller, DataBinding{

	private ManiaDao maniaDao;
	public LoginController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Mania loginInfo = (Mania) model.get("loginInfo");
		if(model.get("loginInfo") == null) {
			return "LoginForm.jsp";
		}else {
			Mania mania = maniaDao.exist(
					loginInfo.getId(),
					loginInfo.getPwd());
			if(mania != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("mania", mania);
				return "redirect:../AnneCustom/index.do";
			}else if(loginInfo.getId()!= null || loginInfo.getPwd() != null) {
				return "LoginFail.jsp";
			}else{
				return "LoginForm.jsp";
			}
		}

	}

	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"loginInfo", dto.Mania.class };
	}
}
