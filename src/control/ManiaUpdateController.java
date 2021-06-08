package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ManiaDao;
import dto.Mania;

@Component("/AnneCustom/update.do")
public class ManiaUpdateController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public ManiaUpdateController setManiaDao(ManiaDao maniaDao) {
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
		if(mania.getAddress() == null) {
			String id = (String) model.get("id");
			System.out.println(id);
			Mania maniaDetail =maniaDao.selectOne(id);
			model.put("mania", maniaDetail);
			return"UpdateMania.jsp";
		}else {
			maniaDao.update(mania);
			HttpSession session = (HttpSession) model.get("session");
			session.setAttribute("mania", mania);
//			return "ManiaInfo.jsp";
			return "redirect:Mania_info.do";
		}
		
	}


}
