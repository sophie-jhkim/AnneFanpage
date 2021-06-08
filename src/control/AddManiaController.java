package control;

import java.util.Map;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneCustom/join.do")
public class AddManiaController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	
	public AddManiaController setMemberDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"mania", dto.Mania.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Mania mania = (Mania) model.get("mania");
		if(mania.getId() ==null) {
			return "/AnneCustom/AddMania.jsp";
		}else {
			maniaDao.insert(mania);
		}
		return "redirect:/project/AnneCustom/LoginForm.jsp";
	}


}





