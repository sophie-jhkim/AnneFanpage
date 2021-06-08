package control;

import java.util.Map;

import dao.NoticeDao;

@Component("/AnneAdmin/Notice.do")
public class NoticeMainController implements Controller{
	private NoticeDao noticeDao;
	public NoticeMainController setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("notice", noticeDao.listNotice());
		return "NoticeMain.jsp";
	}

}
