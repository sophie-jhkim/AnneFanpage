package dto;

import java.sql.Timestamp;

public class QnA {
	private int qseq;
	private String subject;
	private String content; 
	private String reply;
	private String id;
	private String rep;
	private Timestamp indate;
	
	
	public int getQseq() {
		return qseq;
	}
	public QnA setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public QnA setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public QnA setContent(String content) {
		this.content = content;
		return this;
	}
	public String getReply() {
		return reply;
	}
	public QnA setReply(String reply) {
		this.reply = reply;
		return this;
	}
	public String getId() {
		return id;
	}
	public QnA setId(String id) {
		this.id = id;
		return this;
	}
	public String getRep() {
		return rep;
	}
	public QnA setRep(String rep) {
		this.rep = rep;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public QnA setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

}
