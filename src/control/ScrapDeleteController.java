package control;

import java.util.Map;

import dao.ScrapDao;
@Component("/AnneCustom/scrap_delete.do")
public class ScrapDeleteController implements Controller, DataBinding{
	private ScrapDao scrapDao;
	public ScrapDeleteController setScrapDao(ScrapDao scrapDao) {
		this.scrapDao = scrapDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"sseq", Integer.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int sseq = (int) model.get("sseq");
		scrapDao.deleteScrap(sseq);
		return "redirect:../AnneCustom/scrap.do";
	}

}
