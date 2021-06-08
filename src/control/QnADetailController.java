package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnADao;
import dto.Mania;
@Component("/AnneCustom/QnA_detail.do")
public class QnADetailController implements Controller, DataBinding{
	private QnADao qnaDao;
	public QnADetailController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"id", String.class,
				"qna", dto.QnA.class,
				"qseq", Integer.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session =(HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		int qseq = (int) model.get("qseq");
		if(mania == null) {
			return "LoginForm.jsp";
		}else {
			String id = mania.getId();
			System.out.println(qseq);
			model.put("qna", qnaDao.detailQna(id, qseq));
		
		return "QnADetail.jsp";
		}
	}
	
}
