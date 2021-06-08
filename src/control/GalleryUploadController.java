package control;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GalleryDao;
import dto.Gallery;
import dto.Mania;
@Component("/AnneCustom/gallery_upload.do")
public class GalleryUploadController implements Controller, DataBinding{
	private GalleryDao galleryDao;
	public GalleryUploadController setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"photo", dto.Gallery.class,
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int result =-1;
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		Gallery gallery = (Gallery) model.get("photo");
		String savePath = "../AnneCutom/photo";
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
//		ServletContext context = request.getSession().getSetvletContext();
//		String uploadFilePath = context.getRealPath(savePath);
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(gallery.getContent() == null){
			return "PhotoUpload.jsp";
			
		}else{
		
		try {
//			MultipartRequest multi = new MultipartRequest(request,
//					uploadFilePath, uploadFileSizeLimit, encType,
//					new DefaultFileRenamePolicy());
//			Enumeration file = multi.getFileNames();
			
			result = galleryDao.insertPhoto(gallery);
			
			if(result<0) {
				System.out.println("업로드 실패");
			}else {
			return "redirect: gallery.do";
		}
		}catch(Exception e) {
    		e.printStackTrace();
    		}
		
		}
		return "redirect: gallery.do";
	}

}
