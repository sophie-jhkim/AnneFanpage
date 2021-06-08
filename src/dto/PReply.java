package dto;

import java.sql.Timestamp;

public class PReply {
	
	private int rseq;
	private int gseq;
	private String content;
	private String id;
	private String nick;
	private Timestamp indate;
	
	public int getRseq() {
		return rseq;
	}
	public PReply setRseq(int rseq) {
		this.rseq = rseq;
		return this;
	}
	public int getGseq() {
		return gseq;
	}
	public PReply setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	public String getContent() {
		return content;
	}
	public PReply setContent(String content) {
		this.content = content;
		return this;
	}
	public String getId() {
		return id;
	}
	public PReply setId(String id) {
		this.id = id;
		return this;
	}
	public String getNick() {
		return nick;
	}
	public PReply setNick(String nick) {
		this.nick = nick;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public PReply setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}


}
