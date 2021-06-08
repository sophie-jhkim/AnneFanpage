package control;

import java.util.Map;

import dao.NoticeDao;
import dto.Notice;
@Component("/AnneAdmin/Notice_insert.do")
public class NoticeInsertController implements Controller, DataBinding{
	private NoticeDao noticeDao;
	public NoticeInsertController setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"notice", dto.Notice.class,
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Notice notice= (Notice) model.get("notice");
		if(notice.getContent() ==null) {
			return "NoticeInsert.jsp";
			
		}else {
		noticeDao.insertNotice(notice);
		return "redirect:Notice.do";
		}
	}

}
