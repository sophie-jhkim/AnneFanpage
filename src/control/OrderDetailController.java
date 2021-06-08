package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Mania;
import dto.Orders;
@Component("/AnneCustom/order_detail.do")
public class OrderDetailController implements Controller, DataBinding{
	private OrderDao orderDao;
	public OrderDetailController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"order", dto.Orders.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Orders order = (Orders) model.get("order");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			System.out.println(mania);
			String id= mania.getId();
			int oseq = order.getOseq();
			int totalPrice = 0;
			ArrayList<Orders> listOrder= orderDao.listOrderById(id, "%", oseq);
			for(Orders orders : listOrder ) {
				totalPrice += orders.getPrice2()*orders.getQuantity();
			}
			order.setPrice2(totalPrice);
			model.put("order", listOrder);
			model.put("totalPrice", totalPrice);
		}
		return "OrderDetail.jsp";
	}

}
