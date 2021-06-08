package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GalleryDao;
import dao.PReplyDao;
import dto.Gallery;
import dto.Mania;
@Component("/AnneCustom/gallery_detail.do")
public class GalleryDetailController implements Controller, DataBinding{
	private GalleryDao galleryDao;
	private PReplyDao preplyDao;
	public GalleryDetailController setPReplyDao(PReplyDao preplyDao) {
		this.preplyDao = preplyDao;
		return this;
	}
	public GalleryDetailController setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"gseq", Integer.class,
				"photo", dto.Gallery.class,
				"reply", dto.PReply.class
				
				
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
		}else {
			Gallery photoDetail = galleryDao.hit(gallery, gseq);
			model.put("photo", photoDetail);
			model.put("rep", preplyDao.listRep(gseq));
			return "GalleryDetail.jsp";
			
		}

	}

}
