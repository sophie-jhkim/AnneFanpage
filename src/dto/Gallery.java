package dto;

import java.sql.Timestamp;

public class Gallery {
	
	private int gseq;
	private String title;
	private String content;
	private String id;
	private String nick;
	private String img;
	private int hit;
	private Timestamp indate;
	
	public int getGseq() {
		return gseq;
	}
	public Gallery setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Gallery setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Gallery setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public Gallery setId(String id) {
		this.id = id;
		return this;
	}
	public String getNick() {
		return nick;
	}
	public Gallery setNick(String nick) {
		this.nick = nick;
		return this;
	}
	public String getImg() {
		return img;
	}
	public Gallery setImg(String img) {
		this.img = img;
		return this;
	}
	public int getHit() {
		return hit;
	}
	public Gallery setHit(int hit) {
		this.hit = hit;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Gallery setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

	

}
