package control;

import java.util.Map;

import dao.ManiaDao;
import dto.Mania;

@Component("/AnneAdmin/AdminManiaDetail.do")
public class AdminManiaDetailController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public AdminManiaDetailController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"mania", dto.Mania.class,
				"id", String.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Mania mania = (Mania) model.get("mania");
		String id = (String) model.get("id");
		model.put("mania", maniaDao.selectOne(id));
		
		return "AdminManiaInfo.jsp";
	}

}
