package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ScrapDao;
import dto.Mania;

@Component("/AnneCustom/scrap.do")
public class ScrapListController implements Controller, DataBinding{
	private ScrapDao scrapDao;
	public ScrapListController setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id = mania.getId();
			model.put("photo", scrapDao.listScrap(id));
			return "ScrapGallery.jsp";
			
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"scrap", dto.Scrap.class,
				
		};
	}

}
