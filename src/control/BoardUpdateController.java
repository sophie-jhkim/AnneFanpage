package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.ManiaDao;
import dto.Board;
import dto.Mania;

@Component("/AnneCustom/board_update.do")
public class BoardUpdateController implements Controller, DataBinding{
	private BoardDao boardDao;
	private ManiaDao maniaDao;
	
	public BoardUpdateController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}
	public BoardUpdateController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"bseq", Integer.class,
				"board", dto.Board.class,
				"id", String.class,
				"loginInfo", dto.Mania.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
//		Mania mania = (Mania) model.get("mania");
		Board board = (Board) model.get("board");
		int bseq = (int) model.get("bseq");
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(board.getSubject() == null) {
			String id = (String) model.get("id");
			Board boardDetail = boardDao.selectOne(bseq);
			Mania maniaDetail = maniaDao.selectOne(id);
			model.put("board", boardDetail);
			model.put("mania", maniaDetail);
			return "CommUpdate.jsp";
		}else {
			System.out.println("수정 성공");
			boardDao.update(board);
			return "redirect:board_detail.do?bseq="+bseq;
			
		}
	}

}
