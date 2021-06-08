package dto;

import java.sql.Timestamp;

public class BReply {
	
	private int rseq;
	private int bseq;
	private String content;
	private String id;
	private String nick;
	private Timestamp indate;
	
	public int getRseq() {
		return rseq;
	}
	public BReply setRseq(int rseq) {
		this.rseq = rseq;
		return this;
	}
	public int getBseq() {
		return bseq;
	}
	public BReply setBseq(int bseq) {
		this.bseq = bseq;
		return this;
	}
	public String getContent() {
		return content;
	}
	public BReply setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public BReply setId(String id) {
		this.id = id;
		return this;
	}
	public String getNick() {
		return nick;
	}
	public BReply setNick(String nick) {
		this.nick = nick;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public BReply setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}


}
