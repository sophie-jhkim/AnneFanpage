package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GalleryDao;
import dto.Gallery;
import dto.Mania;

@Component("/AnneCustom/gallery_update.do")
public class GalleryUpdateController implements Controller, DataBinding{
	private GalleryDao galleryDao;
	public GalleryUpdateController setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"gseq", Integer.class,
				"photo", dto.Gallery.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Gallery gallery = (Gallery) model.get("photo");
		int gseq = (int) model.get("gseq");
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(gallery.getContent() == null) {
			Gallery photoDetail = galleryDao.selectOne(gseq);
			model.put("photo", photoDetail);
			return "GalleryUpdate.jsp";
		}
		galleryDao.update(gallery); 
		return "redirect:gallery_detail.do?gseq="+gseq;
		
	}
}
