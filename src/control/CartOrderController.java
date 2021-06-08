package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Mania;
import dto.Orders;
@Component("/AnneCustom/cart_order.do")
public class CartOrderController implements Controller, DataBinding{
	private OrderDao orderDao;
	public CartOrderController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
		
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"order", dto.Orders.class,
//				"oseq", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Orders orders = (Orders) model.get("order");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id = mania.getId();
			int oseq = orders.getOseq();
			ArrayList<Orders> orderList = orderDao.listOrderById(id, "1", oseq);
			int totalPrice = 0;
			for(Orders order : orderList) {
				totalPrice += order.getPrice2()*order.getQuantity();
			}
			model.put("order", orderList);
			model.put("totalPrice", totalPrice);
			model.put("title", "주문 완료");
		}
		return "OrderList.jsp";
	}

}
