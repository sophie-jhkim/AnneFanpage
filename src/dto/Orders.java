package dto;

import java.sql.Timestamp;

public class Orders {
	private int odseq;
	private int oseq;
	private int pseq;
	private String id;
	private Timestamp indate;
	private int quantity;
	private String mname;
	private String zip_num;
	private String address;
	private String phone;
	private String pname;
	private int price2;
	private String result;
	
	public int getOdseq() {
		return odseq;
	}
	public Orders setOdseq(int odseq) {
		this.odseq = odseq;
		return this;
	}
	public int getOseq() {
		return oseq;
	}
	public Orders setOseq(int oseq) {
		this.oseq = oseq;
		return this;
	}
	public int getPseq() {
		return pseq;
	}
	public Orders setPseq(int pseq) {
		this.pseq = pseq;
		return this;
	}
	public String getId() {
		return id;
	}
	public Orders setId(String id) {
		this.id = id;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Orders setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public int getQuantity() {
		return quantity;
	}
	public Orders setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public Orders setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public String getZip_num() {
		return zip_num;
	}
	public Orders setZip_num(String zip_num) {
		this.zip_num = zip_num;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Orders setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Orders setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getPname() {
		return pname;
	}
	public Orders setPname(String pname) {
		this.pname = pname;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public Orders setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public String getResult() {
		return result;
	}
	public Orders setResult(String result) {
		this.result = result;
		return this;
	}
	
	

}
