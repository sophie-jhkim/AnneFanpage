package control;

import java.util.Map;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneCustom/findPw.do")
public class FindPwController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public FindPwController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
		
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"email", String.class,
				"id", String.class,
				"mania", dto.Mania.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Mania mania = (Mania) model.get("mania");
		String id = mania.getId();
		String email = mania.getEmail();
		model.put("mania", maniaDao.findPw(id, email));
		
		return "FindPw.jsp";
	}

}