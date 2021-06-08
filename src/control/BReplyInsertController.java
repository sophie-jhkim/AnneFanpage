package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.BReplyDao;
import dao.BoardDao;
import dto.BReply;
import dto.Mania;
@Component("/AnneCustom/breply_insert.do")
public class BReplyInsertController implements Controller, DataBinding{
	private BReplyDao breplyDao;
	public BReplyInsertController setBReplyDao(BReplyDao breplyDao) {
		this.breplyDao = breplyDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"reply", dto.BReply.class,
				"bseq", Integer.class,
				"board", dto.Board.class,
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		BReply breply = (BReply) model.get("reply");
		breplyDao.insert(breply);
		int bseq = (int)model.get("bseq");
		return "redirect:board_detail.do?bseq="+bseq;
	}

}
