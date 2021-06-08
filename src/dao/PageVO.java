package dao;

public class PageVO {
	private int page; //현재 페이지 번호
    private int perPageNum; //한 페이지당 보여줄 게시글 갯수
    
    public int getPageStart() {
        return (this.page-1)*perPageNum;
    }
    
    public PageVO() {
        this.page = 1;
        this.perPageNum = 15;
    }
    
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    public int getPerPageNum() {
        return perPageNum;
    }
    
    
    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

    @Override
    public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
