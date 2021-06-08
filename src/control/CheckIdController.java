package control;

import java.util.Map;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneCustom/checkId.do")
public class CheckIdController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public CheckIdController setManiaDao(ManiaDao maniaDao) {
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
		Mania mania = (Mania) model.get("mania");
//		String id = (String)model.get("id");
		String id = mania.getId();
		model.put("mania", maniaDao.idCheck(id));
			return "Checkid.jsp";
	}

}
