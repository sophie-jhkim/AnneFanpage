package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.GoodsDao;
import dao.ManiaDao;
import dto.Cart;
import dto.Goods;
import dto.Mania;
@Component("/AnneCustom/cart_insert.do")
public class CartInsertController implements Controller, DataBinding{
	private CartDao cartDao;

	public CartInsertController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"cart", dto.Cart.class,
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Cart cart = (Cart) model.get("cart");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			cartDao.insert(cart);
			return "redirect:../AnneCustom/cart.do";
		}		
	}


}
