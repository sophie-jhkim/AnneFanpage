package dto;

import java.sql.Timestamp;

public class Notice {
	private int nseq;
	private String title;
	private String content;
	private String id;
	private String nick;
	private int hit;
	private Timestamp indate;
	
	public int getNseq() {
		return nseq;
	}
	public Notice setNseq(int nseq) {
		this.nseq = nseq;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Notice setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Notice setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public Notice setId(String id) {
		this.id = id;
		return this;
	}
	public String getNick() {
		return nick;
	}
	public Notice setNick(String nick) {
		this.nick = nick;
		return this;
	}
	public int getHit() {
		return hit;
	}
	public Notice setHit(int hit) {
		this.hit = hit;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Notice setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

}
