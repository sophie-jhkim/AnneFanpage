package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneCustom/expired.do")
public class ManiaExpiredController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public ManiaExpiredController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
		"id", String.class,
		"mania", dto.Mania.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Mania mania =(Mania)model.get("mania");
		String id = (String) model.get("id");
		maniaDao.expired(id);
		HttpSession session = (HttpSession) model.get("session");
		session.invalidate();
		
		return "redirect:index.do";
	}

}
