package dto;

import java.sql.Timestamp;

public class Scrap {
	
	private int sseq;
	private String id;
	private int gseq;
	private String gtitle;
	private String img;
	private Timestamp indate;
	
	public int getSseq() {
		return sseq;
	}
	public Scrap setSseq(int sseq) {
		this.sseq = sseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public Scrap setId(String id) {
		this.id = id;
		return this;
	}
	public int getGseq() {
		return gseq;
	}
	public Scrap setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	public String getGtitle() {
		return gtitle;
	}
	public Scrap setGtitle(String gtitle) {
		this.gtitle = gtitle;
		return this;
	}
	public String getImg() {
		return img;
	}
	public Scrap setImg(String img) {
		this.img = img;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Scrap setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	
}
