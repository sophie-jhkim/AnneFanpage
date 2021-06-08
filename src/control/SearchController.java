package control;

import java.util.Map;

import dao.BoardDao;
import dao.GoodsDao;
import dto.Board;
import dto.Goods;
@Component("/AnneCustom/search.do")
public class SearchController implements Controller, DataBinding{
	private GoodsDao goodsDao;
	private BoardDao boardDao;
	public SearchController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}
	public SearchController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"goods", dto.Goods.class,
				"board", dto.Board.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Goods goods = (Goods) model.get("goods");
		Board board = (Board) model.get("board");
//		String name = (String) model.get("name");
		String subject = board.getSubject();
		String name = goods.getName();
		model.put("goods", goodsDao.search(name));
		model.put("board", boardDao.search(subject));
		return "../AnneAdmin/SearchMain.jsp";
	}

}
