package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ManiaDao;
import dto.Mania;
@Component("/AnneAdmin/Manias.do")
public class ManiaListController implements Controller{
	private ManiaDao maniaDao;
	public ManiaListController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		if(mania == null) {
			return "../AnneCustom/LoginInfo.jsp";
		}else{
		model.put("mania", maniaDao.selectList());
		return "../AnneAdmin/ManiaList.jsp";
		}
	}

}
