package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.BReplyDao;
import dao.BoardDao;
import dao.ManiaDao;
import dto.BReply;
import dto.Board;
import dto.Mania;

@Component("/AnneCustom/board_detail.do")
public class BoardDetailController implements Controller, DataBinding{
	private ManiaDao maniaDao;
	private BoardDao boardDao;
	private BReplyDao breplyDao;
	public BoardDetailController setBReplyDao(BReplyDao breplyDao) {
		this.breplyDao = breplyDao;
		return this;
	}
	public BoardDetailController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	public BoardDetailController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"loginInfo", dto.Mania.class, 
				"id", String.class,
				"bseq", Integer.class,
				"board", dto.Board.class,
				"reply", dto.BReply.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Board board = (Board) model.get("board");
		int bseq = (int)model.get("bseq");
		if(mania == null) {
			return "LoginForm.jsp";
		}else{
//			Board boardDetail = boardDao.selectOne(bseq);
			Board boardDetail = boardDao.hit(board, bseq);
			model.put("board", boardDetail);
			System.out.println(bseq);
			model.put("rep", breplyDao.listRep(bseq));
			return "CommDetail.jsp";
		}
	}

}
