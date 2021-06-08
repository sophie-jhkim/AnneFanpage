package dto;

import java.sql.Timestamp;

public class Cart {
	private int cseq;
	private String id;
	private int pseq;
	private int quantity;
	private String result;
	private Timestamp indate;
	private String mname;
	private String pname;
	private String img;
	public String getImg() {
		return img;
	}
	public Cart setImg(String img) {
		this.img = img;
		return this;
	}
	private int price2;
	public String getMname() {
		return mname;
	}
	public Cart setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public Cart setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public Cart setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public int getCseq() {
		return cseq;
	}
	public Cart setCseq(int cseq) {
		this.cseq = cseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public Cart setId(String id) {
		this.id = id;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public Cart setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public Cart setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getResult() {
		return result;
	}
	public Cart setResult(String result) {
		this.result = result;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Cart setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}

}
