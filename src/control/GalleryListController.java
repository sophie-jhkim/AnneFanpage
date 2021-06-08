package control;

import java.util.Map;

import dao.GalleryDao;
@Component("/AnneCustom/gallery.do")
public class GalleryListController implements Controller{
	
	private GalleryDao galleryDao;
	public GalleryListController setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("photo", galleryDao.galleryList());
		return "../AnneCustom/GalleryMain.jsp";
	}

}
