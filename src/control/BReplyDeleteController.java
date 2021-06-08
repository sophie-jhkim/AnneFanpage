package control;

import java.util.Map;

import dao.BReplyDao;

@Component("/AnneCustom/breply_delete.do")
public class BReplyDeleteController implements Controller, DataBinding{
	private BReplyDao breplyDao;
	public BReplyDeleteController setBReplyDao(BReplyDao breplyDao) {
		this.breplyDao = breplyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				
				"bseq", Integer.class,
				"rseq", Integer.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int bseq = (int) model.get("bseq");
		int rseq = (int) model.get("rseq");
		breplyDao.delete(rseq);
		return "redirect:board_detail.do?bseq="+bseq;
	}
}
