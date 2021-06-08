package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ScrapDao;
import dto.Mania;
import dto.Scrap;
@Component("/AnneCustom/scrap_insert.do")
public class ScrapInsertController implements Controller, DataBinding{
	private ScrapDao scrapDao;
	public ScrapInsertController setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"scrap", dto.Scrap.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Scrap scrap = (Scrap) model.get("scrap");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			scrapDao.insert(scrap);
			return "redirect:../AnneCustom/scrap.do";
		}
	}

}
