package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneCustom/Mania_info.do")
public class ManiaInfoController implements Controller, DataBinding{
private ManiaDao maniaDao;
	
	public ManiaInfoController setManiaDao(ManiaDao maniaDao) {
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
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
//		Mania mania =(Mania)model.get("mania");
//		String id = (String) model.get("id");
		String id = mania.getId(); //로그인한  세션 id값으로 해줘야 바로 수정됨
		if(mania == null) {
			return "LoginInfo.jsp";
		}else{
		Mania maniaDetail = maniaDao.selectOne(id);
		model.put("mania", maniaDetail);
		return "ManiaInfo.jsp";
		}
	}

}
