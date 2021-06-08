package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GoodsDao;
import dto.Mania;
import dto.Paging;
@Component("/AnneAdmin/AdminGoods.do")
public class AdminGoodsListController implements Controller, DataBinding{
	private GoodsDao goodsDao;
	public AdminGoodsListController setGoodDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		int page = (Integer) model.get("page");
		Paging paging = new Paging();
		paging.setDisplayRow(10);
		int cnt = paging.getDisplayRow();
		int count = goodsDao.getAllCount();
		
		paging.setTotalCount(count);
		paging.setPage(page);
		if(mania == null) {
			return "LoginInfo.jsp";
		}else{
		model.put("paging", paging);
		model.put("goods", goodsDao.goodsList(page, cnt));
//		model.put("kind", kind);
		return "../AnneAdmin/GoodsList.jsp";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"page", Integer.class,
		};
	}

}
