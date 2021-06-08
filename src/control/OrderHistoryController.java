package control;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Mania;
import dto.Orders;
@Component("/AnneCustom/order_history.do")
public class OrderHistoryController implements Controller, DataBinding{
	private OrderDao orderDao;
	public OrderHistoryController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"order", dto.Orders.class,
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id = mania.getId();
			ArrayList<Integer> orderAll = orderDao.allOrder(id);
			ArrayList<Orders> orderList = new ArrayList<Orders>();
			for(int oseq : orderAll) {
				ArrayList<Orders> orderListIng = orderDao.listOrderById(id, "%", oseq);
				
				Orders order = orderListIng.get(0);
				order.setPname(order.getPname()+" 외  "+ orderListIng.size()+ " 건");
				int totalPrice =0;
				for(Orders orders : orderListIng) {
					totalPrice += orders.getPrice2()*orders.getQuantity();
				}
				order.setPrice2(totalPrice);
				orderList.add(order);
				model.put("totalPrice", totalPrice);
			}
			model.put("order", orderList);
			model.put("title", "Order History");
		}
		
		return "OrderList.jsp";
	}
	
	

}
