package control;

import java.util.Map;

import dao.QnADao;
@Component("/AnneAdmin/QnA_list.do")
public class AdminQnAListController implements Controller, DataBinding{
	private QnADao qnaDao;
	public AdminQnAListController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"qna", dto.QnA.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("qna", qnaDao.QnaAllList());
		return "AdminQnAList.jsp";
	}

}
