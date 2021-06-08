package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.Mania;
import dto.Orders;
@Component("/AnneAdmin/AdminOrderState.do")
public class AdminOrderStateController implements Controller, DataBinding{
	private OrderDao orderDao;
	public AdminOrderStateController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object [] {
				"order", dto.Orders.class,
				"oseq", Integer.class,
				"odseq", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Orders order = (Orders) model.get("order");
		int oseq =(int) model.get("oseq");
		int odseq =(int) model.get("odseq");
		
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			orderDao.changeState(order);
			return "redirect:../AnneAdmin/AdminOrderDetail.do?oseq="+oseq;
			
		}
	}

}
