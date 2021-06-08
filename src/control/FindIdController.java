package control;

import java.util.Map;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneCustom/findId.do")
public class FindIdController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public FindIdController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
		
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"mania", dto.Mania.class,
				"email", String.class,
				"phone", String.class
				
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Mania mania =(Mania) model.get("mania");
		String phone = mania.getPhone();
		String  email = mania.getEmail();
		model.put("mania", maniaDao.findId(phone, email));
		
		return "FindId.jsp";
	}

}
