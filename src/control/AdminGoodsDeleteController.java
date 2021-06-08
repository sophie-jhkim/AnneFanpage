package control;

import java.util.Map;

import dao.GoodsDao;

@Component("/AnneAdmin/goods_delete.do")
public class AdminGoodsDeleteController implements Controller, DataBinding{
	private GoodsDao goodsDao;
	public AdminGoodsDeleteController setGoodDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"pseq", Integer.class,
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int pseq= (int) model.get("pseq");
		goodsDao.deleteGoods(pseq);
		return "redirect:../AnneAdmin/AdminGoods.do?page=1";
	}

}
