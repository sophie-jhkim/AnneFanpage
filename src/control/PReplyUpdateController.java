package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GalleryDao;
import dao.PReplyDao;
import dto.BReply;
import dto.Board;
import dto.Gallery;
import dto.Mania;
import dto.PReply;
@Component("/AnneCustom/preply_update.do")
public class PReplyUpdateController implements Controller, DataBinding{
	private PReplyDao preplyDao;
	private GalleryDao galleryDao;
	public PReplyUpdateController setPReplyDao(PReplyDao preplyDao) {
		this.preplyDao = preplyDao;
		return this;
	}
	public PReplyUpdateController setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
		return this;
	}
	

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
		"reply", dto.PReply.class,
//		"gseq", Integer.class,
		"photo", dto.Gallery.class,
		"rseq", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		PReply preply = (PReply) model.get("reply");
		Gallery photo = (Gallery) model.get("photo");
		int rseq =(int) model.get("rseq");
		int gseq = preply.getGseq();
//		int gseq =(int) model.get("gseq");
		Gallery galleryDetail = galleryDao.selectOne(gseq);
		model.put("photo", galleryDetail);
		if(preply.getContent() == null) {
			PReply detail = preplyDao.selectOne(rseq);
			model.put("reply", detail);
			System.out.println(rseq);
			System.out.println("gseq : "+gseq);
			return "../AnneCustom/GalleryDetail_r.jsp";
		}else {
			System.out.println(preply.getContent());
		preplyDao.update(preply);
		return "redirect:gallery.do";
//		return "redirect:gallery_detail.do?gseq="+gseq;
		}
	}

}
