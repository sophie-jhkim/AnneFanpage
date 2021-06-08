package control;

import java.util.Map;

import dao.CartDao;
@Component("/AnneCustom/cart_delete.do")
public class CartDeleteController implements Controller, DataBinding{
	private CartDao cartDao;
	public CartDeleteController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int cseq = (int) model.get("cseq");
		cartDao.deleteCart(cseq);
		
		return "redirect:../AnneCustom/cart.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"cseq", Integer.class
		};
	}

}
