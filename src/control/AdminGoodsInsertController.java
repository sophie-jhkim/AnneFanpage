package control;

import java.util.Enumeration;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GoodsDao;
import dto.Goods;
import dto.Mania;

@Component("/AnneAdmin/goods_insert.do")
public class AdminGoodsInsertController implements Controller, DataBinding{
	private GoodsDao goodsDao;
	public AdminGoodsInsertController setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"goods", dto.Goods.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int result = -1;
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Goods goods = (Goods) model.get("goods");
		String savePath = "../AnneAdmin/AnnImage/goods";
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
//		ServletContext context = request.getSession().getSetvletContext();
//		String uploadFilePath = context.getRealPath(savePath);
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(goods.getName() == null){
			return "../AnneAdmin/GoodsUpload.jsp";
			
		}else{
			
			try {
//				MultipartRequest multi = new MultipartRequest(request,
//						uploadFilePath, uploadFileSizeLimit, encType,
//						new DefaultFileRenamePolicy());
//				Enumeration file = multi.getFileNames();
				
				result = goodsDao.insert(goods);
				
				if(result<0) {
					System.out.println("업로드 실패");
				}else {
			
				return "redirect:../AnneAdmin/AdminGoods.do?page=1";
				}
			}catch(Exception e) {
	    		e.printStackTrace();
	    		}
			
			}
			return "redirect:../AnneAdmin/AdminGoods.do?page=1";
	}

}
