package control;

import java.util.Map;

import dao.QnADao;
@Component("/AnneCustom/QnA_delete.do")
public class QnADeleteController implements Controller, DataBinding{
	private QnADao qnaDao;
	public QnADeleteController setQnADao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"qseq", Integer.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		int qseq = (int) model.get("qseq");
		qnaDao.delete(qseq);
		return "redirect:QnA.do";
	}

}
