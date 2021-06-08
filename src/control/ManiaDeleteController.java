package control;

import java.util.Map;
import javax.servlet.http.HttpSession;
import dao.ManiaDao;


@Component("/AnneCustom/delete.do")
public class ManiaDeleteController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public ManiaDeleteController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String) model.get("id");
		maniaDao.delete(id);
		
		HttpSession session = (HttpSession) model.get("session");
		session.invalidate();
		
		return "redirect:index.do";
	}

}
