package dto;

import java.sql.Timestamp;

public class Mania {
	private String id;
	private String pwd;
	private String name;
	private String nick;
	private String email;
	private String zip_num;
	private String address;
	private String phone;
	private String ad;
	private String rate;
	private String useyn;
	private Timestamp indate ;
	
	public String getNick() {
		return nick;
	}
	public Mania setNick(String nick) {
		this.nick = nick;
		return this;
	}
	
	public String getId() {
		return id;
	}
	public Mania setId(String id) {
		this.id = id;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public Mania setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getName() {
		return name;
	}
	public Mania setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Mania setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getZip_num() {
		return zip_num;
	}
	public Mania setZip_num(String zip_num) {
		this.zip_num = zip_num;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Mania setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Mania setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getAd() {
		return ad;
	}
	public Mania setAd(String ad) {
		this.ad = ad;
		return this;
	}
	public String getRate() {
		return rate;
	}
	public Mania setRate(String rate) {
		this.rate = rate;
		return this;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public Mania setIndate(Timestamp indate) {
		this.indate = indate;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public Mania setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}


}
