package dto;

import java.sql.Timestamp;

public class Board {
	
	private int bseq;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String nick;
	private int hit;
	private Timestamp indate;
	
	public int getBseq() {
		return bseq;
	}
	public Board setBseq(int bseq) {
		this.bseq = bseq;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public Board setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Board setContent(String content) {
		this.content = content;
		return this;
	}
	public String getReply() {
		return reply;
	}
	public Board setReply(String reply) {
		this.reply = reply;
		return this;
	}
	public String getId() {
		return id;
	}
	public Board setId(String id) {
		this.id = id;
		return this;
	}
	public String getNick() {
		return nick;
	}
	public Board setNick(String nick) {
		this.nick = nick;
		return this;
	}
	public int getHit() {
		return hit;
	}
	public Board setHit(int hit) {
		this.hit = hit;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Board setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}


}
