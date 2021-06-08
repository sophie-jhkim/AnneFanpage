package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.PReplyDao;
import dto.Mania;
import dto.PReply;

@Component("/AnneCustom/preply_insert.do")
public class PReplyInsertController implements Controller, DataBinding{
	private PReplyDao preplyDao;
	public PReplyInsertController setPReplyDao(PReplyDao preplyDao) {
		this.preplyDao = preplyDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"reply", dto.PReply.class,
				"gseq", Integer.class,
				"gallery", dto.Gallery.class,
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		PReply preply = (PReply) model.get("reply");
		preplyDao.insert(preply);
		int gseq = (int)model.get("gseq");
		return "redirect:gallery_detail.do?gseq="+gseq;
	}

}
