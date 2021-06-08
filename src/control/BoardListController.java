package control;

import java.util.Map;

import dao.BoardDao;

@Component("/AnneCustom/board.do")
public class BoardListController implements Controller{
	
	private BoardDao boardDao;
	public BoardListController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("board", boardDao.listBoard());
		return "CommunityMain.jsp";
	}

}
