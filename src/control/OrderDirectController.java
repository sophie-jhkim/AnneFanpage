package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GoodsDao;
import dao.OrderDao;
import dto.Goods;
import dto.Mania;
import dto.Orders;
@Component("/AnneCustom/order_direct.do")
public class OrderDirectController implements Controller, DataBinding{
	private OrderDao orderDao;
	private GoodsDao goodsDao;
	public OrderDirectController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	public OrderDirectController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"order", dto.Orders.class,
				"goods", dto.Goods.class,
//				"pseq", Integer.class,
//				"quantity", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania =(Mania) session.getAttribute("mania");
		String id = mania.getId();
		Orders orders = (Orders) model.get("order");
//		Goods goods = (Goods) model.get("goods");
//		int pseq = (int)model.get("pseq");
//		int quantity = (int)model.get("quantity");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			orderDao.directInsert(orders, id);
		}
		return "redirect:../AnneCustom/order.do";
	}

}
