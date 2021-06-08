package control;

import java.util.Map;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneAdmin/Level.do")
public class ManiaLevelController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public ManiaLevelController setManiaDao(ManiaDao maniaDao) {
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
		String id = (String) model.get("id");
		maniaDao.changeLevel(mania);
		return "redirect:../AnneAdmin/AdminManiaDetail.do?id="+id;
	}

}
