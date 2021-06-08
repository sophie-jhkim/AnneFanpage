package control;

import java.util.Map;

import dao.GoodsDao;
import dto.Goods;
@Component("/AnneAdmin/GoodsChange.do")
public class GoodsChangeController implements Controller, DataBinding{
	
	private GoodsDao goodsDao;
	public GoodsChangeController setGoodsDao(GoodsDao goodsDao) {
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
		Goods goods = (Goods) model.get("goods");
		int pseq = (int) model.get("pseq");
		goodsDao.change(goods);
		
		return "redirect:../AnneAdmin/AdminGoods.do";
	}

}
