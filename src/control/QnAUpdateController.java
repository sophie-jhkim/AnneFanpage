package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnADao;
import dto.Mania;
import dto.QnA;

@Component("/AnneCustom/QnA_update.do")
public class QnAUpdateController implements Controller, DataBinding{
	private QnADao qnaDao;
	public QnAUpdateController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"qna", dto.QnA.class,
				"qseq", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		Mania mania = (Mania) session.getAttribute("mania");
		QnA qna = (QnA) model.get("qna");
		int qseq = (int) model.get("qseq");
		if(mania == null) {
			return "LoginForm.jsp";
		}else if(qna.getSubject() == null) {
			String id = mania.getId();
			model.put("qna", qnaDao.detailQna(id, qseq));
			return "QnAUpdate.jsp";
		}else {
			qnaDao.update(qna);
			return "redirect:../AnneCustom/QnA_detail.do?qseq="+qseq;
		}
	}

}
