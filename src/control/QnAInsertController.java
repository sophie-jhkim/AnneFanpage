package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnADao;
import dto.Mania;
import dto.QnA;
@Component("/AnneCustom/QnA_insert.do")
public class QnAInsertController implements Controller, DataBinding{
	private QnADao qnaDao;
	public QnAInsertController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id" , String.class,
				"qna", dto.QnA.class,
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		
		QnA qna = (QnA) model.get("qna");
		if(mania == null){
			return "LoginForm.jsp";
		}else if(qna.getContent() == null){
			
			return "../AnneCustom/QnAInsert.jsp";
		}else {
			String id = mania.getId();
			qnaDao.insertQna(qna, id);
			return "redirect:QnA.do";
		}
	}

}
