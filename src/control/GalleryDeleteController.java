package control;

import java.util.Map;

import dao.GalleryDao;

@Component("/AnneCustom/gallery_delete.do")
public class GalleryDeleteController implements Controller, DataBinding {
	private GalleryDao galleryDao;
	public GalleryDeleteController setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"gseq", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int gseq = (int) model.get("gseq");
		galleryDao.delete(gseq);
		return "redirect:../AnneCustom/gallery.do";
	}

}
