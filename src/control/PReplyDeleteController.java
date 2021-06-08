package control;

import java.util.Map;

import dao.PReplyDao;
@Component("/AnneCustom/preply_delete.do")
public class PReplyDeleteController implements Controller, DataBinding{
	private PReplyDao preplyDao;
	public PReplyDeleteController setPReplyDao(PReplyDao preplyDao) {
		this.preplyDao = preplyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"gseq", Integer.class,
				"rseq", Integer.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int gseq = (int) model.get("gseq");
		int rseq = (int) model.get("rseq");
		preplyDao.delete(rseq);
		return "redirect:gallery_detail.do?gseq="+gseq;
	}

}
