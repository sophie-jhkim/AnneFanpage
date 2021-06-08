package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnADao;
import dto.Mania;

@Component("/AnneCustom/QnA.do")
public class QnAListController implements Controller, DataBinding{
	private QnADao qnaDao;
	public QnAListController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"qna", dto.QnA.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id = mania.getId();
			model.put("qna", qnaDao.listQna(id));
			
			return "QnAList.jsp";
		}
	}
	

}
