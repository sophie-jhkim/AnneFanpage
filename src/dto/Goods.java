package dto;

import java.sql.Timestamp;

public class Goods {
	
	private int pseq;
	private String name;
	private int kind; 
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String img;
	private String useyn;
	private String bestyn;
	private Timestamp indate;
	
	
	public int getPseq() {
		return pseq;
	}
	public Goods setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getName() {
		return name;
	}
	public Goods setName(String name) {
		this.name = name;
		return this;
	}
	public int getKind() {
		return kind;
	}
	public Goods setKind(int kind) {
		this.kind = kind;
		return this;
	}
	public int getPrice1() {
		return price1;
	}
	public Goods setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public Goods setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getPrice3() {
		return price3;
	}
	public Goods setPrice3(int price3) {
		this.price3 = price3;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Goods setContent(String content) {
		this.content = content;
		return this;
	}
	public String getImg() {
		return img;
	}
	public Goods setImg(String img) {
		this.img = img;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public Goods setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public String getBestyn() {
		return bestyn;
	}
	public Goods setBestyn(String bestyn) {
		this.bestyn = bestyn;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Goods setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}


}
