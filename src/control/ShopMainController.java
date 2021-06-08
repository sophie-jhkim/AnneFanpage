package control;

import java.util.Map;

import dao.GoodsDao;
import dto.Goods;
@Component("/AnneAdmin/Shop.do")
public class ShopMainController implements Controller{

	private GoodsDao goodsDao;
	public ShopMainController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("goods", goodsDao.goodsSimpleList());
		model.put("best", goodsDao.bestGoods());
		return "../AnneAdmin/ShopMain.jsp";
	}

}
