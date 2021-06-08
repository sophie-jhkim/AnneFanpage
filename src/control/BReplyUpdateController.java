package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.BReplyDao;
import dao.BoardDao;
import dto.BReply;
import dto.Board;
import dto.Mania;
@Component("/AnneCustom/breply_update.do")
public class BReplyUpdateController implements Controller, DataBinding{
	private BReplyDao breplyDao;
	private BoardDao boardDao;
	public BReplyUpdateController setBReplyDao(BReplyDao breplyDao) {
		this.breplyDao = breplyDao;
		return this;
	}
	public BReplyUpdateController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
		"reply", dto.BReply.class,
//		"bseq", Integer.class,
		"board", dto.Board.class,
		"rseq", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		BReply breply = (BReply) model.get("reply");
		Board board = (Board) model.get("board");
		int rseq =(int) model.get("rseq");
//		int bseq =(int) model.get("bseq");
		int bseq = breply.getBseq();
		Board boardDetail = boardDao.selectOne(bseq);
		model.put("board", boardDetail);
		if(breply.getContent() == null) {
			BReply detail = breplyDao.selectOne(rseq);
			model.put("reply", detail);
			System.out.println(rseq);
			System.out.println("bseq : "+bseq);
			return "../AnneCustom/CommDetail_r.jsp";
		}else {
		breplyDao.update(breply);
		return "redirect:board.do";
//		return "redirect:board_detail.do?bseq="+bseq;
		}
	}

}
