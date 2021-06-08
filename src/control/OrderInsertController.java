package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.OrderDao;
import dto.Cart;
import dto.Mania;
import dto.Orders;
@Component("/AnneCustom/order_insert.do")
public class OrderInsertController implements Controller, DataBinding{
	private OrderDao orderDao;
	private CartDao cartDao;
	public OrderInsertController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	public OrderInsertController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"order", dto.Orders.class,
				"cart", dto.Cart.class,
				"id", String.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania =(Mania) session.getAttribute("mania");
		Orders order = (Orders) model.get("order");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id = mania.getId();
//			String id = (String)model.get("id");
			ArrayList<Cart> cartList = cartDao.listCart(id);
//			System.out.println(cartList);
			int maxOseq = orderDao.insertOrder(cartList, id);
			return "redirect:../AnneCustom/order_detail.do?oseq="+maxOseq;
			//여기 ★★★★★아니고 바로 주소로 리턴해주면 반복 입력(?). insertOrder 엄청 들어감
		}
	}

}
