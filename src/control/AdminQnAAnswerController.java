package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnADao;
import dto.Mania;
import dto.QnA;
@Component("/AnneAdmin/QnA_answer.do")
public class AdminQnAAnswerController implements Controller, DataBinding{
	private QnADao qnaDao;
	public AdminQnAAnswerController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		QnA qna = (QnA) model.get("qna");
//		int qseq = (int) model.get("qseq");
		int qseq = qna.getQseq();
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(qna.getReply() == null) {
			model.put("qna", qnaDao.adminDetailQna(qseq));
			return "QnAAnswerInsert.jsp";
		}else {
			qnaDao.answerQna(qna, qseq);
			return "redirect:../AnneAdmin/QnA_answer.do?qseq="+qseq;
		}
		
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"qna", dto.QnA.class
		};
	}

}
