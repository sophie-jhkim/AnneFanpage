package control;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import dao.OrderDao;
import dto.Mania;
import dto.Orders;

@Component("/AnneAdmin/AdminOrders.do")
public class AdminOrderListController implements Controller, DataBinding{
	private OrderDao orderDao;
	public AdminOrderListController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Orders ordering = (Orders) model.get("order");
		if(mania == null) {
			return "../AnneCustom/LoginForm.jsp";
		}else {
		String id = mania.getId();
		ArrayList<Integer> orderAll = orderDao.allOrderAdmin();
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		for(int oseq : orderAll) {
			ArrayList<Orders> orderListIng = orderDao.listOrderAdmin(oseq);
			
			Orders order = orderListIng.get(0);
			order.setPname(order.getPname()+" 외  "+ orderListIng.size()+" 건 ");
			int totalPrice = 0;
			for(Orders orders : orderListIng) {
				totalPrice += orders.getPrice2()*orders.getQuantity();
			}
			order.setPrice2(totalPrice);
			orderList.add(order);
			model.put("totalPrice", totalPrice);
		}
		
		
		//-------------실패작
//		ArrayList<Integer> orderAll = orderDao.selectSeqOrder(id);
		
//		for(int oseq : orderAll) {
//			ArrayList<Orders> orderListIng = orderDao.listOrderById("%", "%", oseq);
//		
//			Orders order = orderListIng.get(0);
//			order.setPname(order.getPname()+" 외  "+ orderListIng.size()+ " 건");
//			int totalPrice =0;
//			for(Orders orders : orderListIng) {
//				totalPrice += orders.getPrice2()*orders.getQuantity();
//			}
//			order.setPrice2(totalPrice);
//			orderList.add(order);
//			model.put("totalPrice", totalPrice);
//		}
		//-------------실패작
//		model.put("order", orderDao.AdminOrderList());
		model.put("order", orderList);
		}
		return "AdminOrderList.jsp";
		
		
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"order", dto.Orders.class
		};
	}

}
