package control;

import java.util.Map;
import javax.servlet.http.HttpSession;
import dao.GoodsDao;
import dto.Goods;
import dto.Mania;


@Component("/AnneAdmin/goods_update.do")
public class AdminGoodsUpdateController implements Controller, DataBinding{
	private GoodsDao goodsDao;
	public AdminGoodsUpdateController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"pseq" , Integer.class,
				"goods", dto.Goods.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Goods goods = (Goods) model.get("goods");
		int pseq = (int) model.get("pseq");
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(goods.getContent() == null) {
			Goods goodsDetail = goodsDao.selectOne(pseq);
			model.put("goods", goodsDetail);
			return "GoodsUpdate.jsp";
		}else {
			goodsDao.update(goods);
			return "redirect:../AnneAdmin/ShopDetail.do?pseq="+pseq;
		}
		
	}

}



