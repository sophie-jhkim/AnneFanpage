package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dto.Board;
import dto.Mania;

@Component("/AnneCustom/board_insert.do")
public class BoardInsertController implements Controller, DataBinding{
	private BoardDao boardDao;
	
	public BoardInsertController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"board", dto.Board.class,
				"loginInfo", dto.Mania.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		
		Board board = (Board) model.get("board");
		if(mania == null){
			return "LoginForm.jsp";
		}else if(board.getContent() == null) {
			return "/AnneCustom/CommInsert.jsp";
		}else {
			boardDao.insertBoard(board);
			return "redirect:board.do";
		}
	}

}
