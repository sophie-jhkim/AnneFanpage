package control;

import java.util.Map;

import dao.NoticeDao;
import dto.Notice;
@Component("/AnneAdmin/Notice_update.do")
public class NoticeUpdateController implements Controller, DataBinding{
	private NoticeDao noticeDao;
	public NoticeUpdateController setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"nseq", Integer.class,
				"notice", dto.Notice.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Notice notice = (Notice)model.get("notice");
		int nseq = (int) model.get("nseq");
		if(notice.getContent() ==null) {
			Notice noticeDetail = noticeDao.selectOne(nseq);
			model.put("notice", noticeDetail);
			return "NoticeUpdate.jsp";
		}else {
			noticeDao.update(notice);
			return "redirect:Notice_detail.do?nseq="+nseq;
		}
		

}
}
