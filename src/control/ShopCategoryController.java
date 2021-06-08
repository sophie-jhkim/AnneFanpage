package control;

import java.util.Map;

import dao.GoodsDao;
@Component("/AnneAdmin/Category.do")
public class ShopCategoryController implements Controller, DataBinding{
	
	private GoodsDao goodsDao;
	public ShopCategoryController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"kind", Integer.class
				
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int kind = (int) model.get("kind");
		model.put("goods", goodsDao.kindList(kind));
		return "../AnneAdmin/ShopCategory.jsp";
	}


}
