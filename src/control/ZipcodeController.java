package control;

import java.util.Map;

import dao.ZipCodeDao;
import dto.ZipCode;
@Component("/AnneCustom/zipcode.do")
public class ZipcodeController implements Controller, DataBinding{
	private ZipCodeDao zipcodeDao;
	public ZipcodeController setZipcodeDao(ZipCodeDao zipcodeDao) {
		this.zipcodeDao = zipcodeDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"zipcode", dto.ZipCode.class,
				"dong", String.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		ZipCode zipcode = (ZipCode) model.get("zipcode");
		String dong = zipcode.getDong();
		model.put("zipcode", zipcodeDao.address(dong));
		
		return "../AnneCustom/Post.jsp";
	}

}
