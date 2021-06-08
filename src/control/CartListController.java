package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.ManiaDao;
import dto.Cart;
import dto.Mania;
@Component("/AnneCustom/cart.do")
public class CartListController implements Controller, DataBinding{
	private CartDao cartDao;
	private ManiaDao maniaDao;
	public CartListController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}
	public CartListController setManiaDao(ManiaDao maniaDao) {
		this.maniaDao = maniaDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"cart", dto.Cart.class,
				"mania", dto.Mania.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
//		Mania mania = (Mania)model.get("mania");
//		String id = (String)model.get("id");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
		String id = mania.getId();
		model.put("cart", cartDao.listCart(id));
		int totalPrice =0;
		for(Cart pcart : cartDao.listCart(id)) {
			totalPrice += pcart.getPrice2()*pcart.getQuantity();
		}
		model.put("totalPrice", totalPrice);
		return "CartList.jsp";
		}
	}


}
