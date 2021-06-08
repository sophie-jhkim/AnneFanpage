package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Mania;
import dto.Orders;
@Component("/AnneCustom/order.do")
public class OrderListController implements Controller, DataBinding{
	private OrderDao orderDao;
	public OrderListController setOrderDao(OrderDao orderDao) {
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
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id= mania.getId();
			ArrayList<Integer> orderAll = orderDao.selectSeqOrderIng(id);
			ArrayList<Orders> orderList = new ArrayList<Orders>();
			
			for(int oseq : orderAll) {
				String result = "1";
				ArrayList<Orders> orderListIng = orderDao.listOrderById(id, result, oseq);
				Orders order = orderListIng.get(0);
				order.setPname(order.getPname() +" 외  "+ orderListIng.size()+"건");
				int totalPrice = 0;
				for(Orders orders : orderListIng) {
					totalPrice += orders.getPrice2()*orders.getQuantity();
				}
				order.setPrice2(totalPrice);
				orderList.add(order);
				model.put("totalPrice", totalPrice);
			}
			model.put("order", orderList);
			model.put("title", "진행중인 주문내역");
		}
		return "OrderList.jsp";
	}

}
