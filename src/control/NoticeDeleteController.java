package control;

import java.util.Map;

import dao.NoticeDao;
@Component("/AnneAdmin/Notice_delete.do")
public class NoticeDeleteController implements Controller, DataBinding{
	private NoticeDao noticeDao;
	public NoticeDeleteController setNoticeDAo(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int nseq = (int) model.get("nseq");
		noticeDao.delete(nseq);
		return "redirect:../AnneAdmin/Notice.do";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"nseq", Integer.class
		};
	}

}
