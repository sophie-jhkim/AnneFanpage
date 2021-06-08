package control;

import java.util.Map;

import dao.GoodsDao;
import dto.Goods;
@Component("/AnneAdmin/ShopDetail.do")
public class ShopDetailController implements Controller, DataBinding{
	private GoodsDao goodsDao;
	public ShopDetailController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	 }
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"pseq", Integer.class,
				"goods", dto.Goods.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int pseq = (int) model.get("pseq");
		Goods goods = (Goods) model.get("goods");
		Goods goodsDetail = goodsDao.selectOne(pseq);
		model.put("goods", goodsDetail);
		return "../AnneAdmin/ShopDetail.jsp";
	}


}
