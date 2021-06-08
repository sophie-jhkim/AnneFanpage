package control;

import java.util.Map;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.GoodsDao;
import dao.ManiaDao;
import dao.NoticeDao;
import dto.Mania;

@Component("/AnneCustom/index.do")
public class IndexController implements Controller{
	private NoticeDao noticeDao;
	private ManiaDao maniaDao;
	private GoodsDao goodsDao;
	private BoardDao boardDao;
	public IndexController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	public IndexController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}
	public IndexController setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
		return this;
	}
	public IndexController setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
//		HttpSession session = (HttpSession) model.get("session");
//		Mania mania = (Mania) session.getAttribute("mania");
		model.put("best", goodsDao.bestGoods());
		model.put("notice", noticeDao.listNotice());
		model.put("board", boardDao.listBoard());
		return "/AnneCustom/index.jsp";
	}
	

}
