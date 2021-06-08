package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Mania;
import dto.Orders;

@Component("/AnneAdmin/AdminOrderDetail.do")
public class AdminOrderDetailController implements Controller, DataBinding{
	private OrderDao orderDao;
	public AdminOrderDetailController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"order", dto.Orders.class,
//				"odseq", Integer.class
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
			int oseq = order.getOseq();
			System.out.println("OSEQ : "+oseq);
			int totalPrice=0;
			ArrayList<Orders> listOrder = orderDao.listOrderAdmin(oseq);
			for(Orders orders : listOrder) {
				totalPrice += orders.getPrice2()*orders.getQuantity();
			}
			order.setPrice2(totalPrice);
			model.put("order", listOrder);
			model.put("totalPrice", totalPrice);
			
			return "OrderDetail.jsp";
		}
	}

}
