package control;

import java.util.Map;

import dao.ManiaDao;

@Component("/AnneAdmin/Manias_useyn.do")
public class ManiaListUseynController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	public ManiaListUseynController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String useyn = (String)model.get("useyn");
		model.put("mania", maniaDao.useynList(useyn));
		return "../AnneAdmin/ManiaList.jsp";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"useyn" , String.class
		};
	}

}
