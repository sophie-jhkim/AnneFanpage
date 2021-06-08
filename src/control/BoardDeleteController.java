package control;

import java.util.Map;

import dao.BoardDao;

@Component("/AnneCustom/board_delete.do")
public class BoardDeleteController implements Controller, DataBinding{
		private BoardDao boardDao;
		public BoardDeleteController setBoardDao(BoardDao boardDao) {
			this.boardDao = boardDao;
			return this;
		}
		
	@Override
	public String execute(Map<String, Object> model) throws Exception {
			int bseq = (int) model.get("bseq");
			boardDao.delete(bseq);
			return "redirect:../AnneCustom/board.do";
		}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"bseq", Integer.class
		};
	}


}
