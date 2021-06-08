package control;

import java.util.Map;

import dao.NoticeDao;
import dto.Notice;
@Component("/AnneAdmin/Notice_detail.do")
public class NoticeDetailController implements Controller, DataBinding{
	private NoticeDao noticeDao;
	public NoticeDetailController setNoticeDao(NoticeDao noticeDao) {
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
		Notice notice = (Notice) model.get("notice");
		int nseq= (int) model.get("nseq");
		model.put("notice", noticeDao.hit(notice, nseq));
		return "NoticeDetail.jsp";
	}

}
