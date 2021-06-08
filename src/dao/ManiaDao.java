package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;
import dto.Mania;

public class ManiaDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public Mania selectOne(String id) throws Exception{
		Mania mania = null;
		String sql = "SELECT id, pwd, name, nick, email, zip_num,"
				+ "address, phone, ad, rate, useyn, indate FROM MANIA WHERE ID='"+id+"'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				mania = new Mania();
				mania.setId(rs.getString("id"));
				mania.setPwd(rs.getString("pwd"));
				mania.setName(rs.getString("name"));
				mania.setNick(rs.getString("nick"));
				mania.setEmail(rs.getString("email"));
				mania.setZip_num(rs.getString("zip_num"));
				mania.setAddress(rs.getString("address"));
				mania.setPhone(rs.getString("phone"));
				mania.setAd(rs.getString("ad"));
				mania.setRate(rs.getString("rate"));
				mania.setUseyn(rs.getString("useyn"));
				mania.setIndate(rs.getTimestamp("indate"));
				return mania;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try{
				if(rs !=null) rs.close();
				if(stmt !=null) rs.close();
				if(conn !=null) rs.close();
			}catch(Exception e) {}
		}
		return null;
	}
	
	//------------------------------------------------------------로그인
	public Mania exist(String id, String pwd) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MANIA WHERE ID=? AND PWD=? AND USEYN='y'";
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Mania()
						.setId(rs.getString("id"))
						.setPwd(rs.getString("pwd"))
						.setName(rs.getString("name"))
						.setNick(rs.getString("nick"))
						.setPhone(rs.getString("phone"))
						.setEmail(rs.getString("email"))
						.setAddress(rs.getString("address"))
						.setAd(rs.getString("ad"))
						.setRate(rs.getString("rate"))
						.setIndate(rs.getTimestamp("indate"));
				
			}else {
				return null;
				}
			
		}catch(Exception e) {
			throw e;
			
		}finally {
			try { 
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
			}
	}
	
	//------------------------------------------------------------회원가입
	public int insert(Mania mania) throws Exception{
		Connection conn = null;
		PreparedStatement stmt= null;
		int result = -1;
		String sql = "INSERT INTO MANIA(ID, PWD, NAME, NICK, EMAIL,"
				+ "ZIP_NUM, ADDRESS, PHONE, AD) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mania.getId());
			stmt.setString(2, mania.getPwd());
			stmt.setString(3, mania.getName());
			stmt.setString(4, mania.getNick());
			stmt.setString(5, mania.getEmail());
			stmt.setString(6, mania.getZip_num());
			stmt.setString(7, mania.getAddress());
			stmt.setString(8, mania.getPhone());
			stmt.setString(9, mania.getAd());
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();
				}catch(Exception e) {}
		}
		return result;
	}
	
	//------------------------------------------------------------정보 수정
	
	public int update(Mania mania) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE MANIA SET PWD=?, NAME=?, NICK=?, EMAIL=?,"
				+ "ADDRESS=?, PHONE=?, AD=? WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mania.getPwd());
			stmt.setString(2, mania.getName());
			stmt.setString(3, mania.getNick());
			stmt.setString(4, mania.getEmail());
			stmt.setString(5, mania.getAddress());
			stmt.setString(6, mania.getPhone());
			stmt.setString(7, mania.getAd());
			stmt.setString(8, mania.getId());
			return stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		
	}
	//------------------------------------------------------------회원 탈퇴
	public int delete(String id) throws Exception{
		Connection conn= null;
		Statement stmt = null;
		int result = -1;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate("DELETE FROM MANIA WHERE ID='"+id+"'");
			
		}catch (Exception e) {
			throw new ServletException(e);			
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {}
		}
		return result;
	}
	
	//------------------------------------------------------------일단 탈퇴
	
	public int expired(String id) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE MANIA SET USEYN='n' WHERE ID='"+id+"'";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			return stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
		
	}
	//----------------------------------------------------ID찾기 id중복 확인
	public Mania idCheck(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		int result= -1;
		String sql = "SELECT ID FROM MANIA WHERE ID=?";
		try {
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				return new Mania().setId(rs.getString("id"));
			}else {
				return null;
			}
		}catch(SQLException e) {
			throw new ServletException(e);
		}finally {
			try{
				  if(rs != null) rs.close();
				  if(pstmt != null) pstmt.close();
				  if(conn != null) conn.close();
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
		}
		
	}
	//----------------------------------------------------관리자용 회원 리스트
	public List<Mania> selectList() throws Exception {
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs= null;
		List<Mania> manias = new ArrayList<>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Mania ORDER BY NAME ASC");
					while(rs.next()) {
						manias.add(new Mania().setId(rs.getString(1)).setPwd(rs.getString(2)).setName(rs.getString(3))
								.setNick(rs.getString(4)).setEmail(rs.getString(5)).setZip_num(rs.getString(6))
								.setAddress(rs.getString(7)).setPhone(rs.getString(8)).setAd(rs.getString(9))
								.setRate(rs.getString(10)).setUseyn(rs.getString(11)).setIndate(rs.getTimestamp(12)));
					}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
			if(conn !=null) conn.close();}catch(Exception e) {}
		}
		
		return manias;
	}
	//----------------------------------------------------패스워드 찾기
	public Mania findPw(String id, String email) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT PWD FROM MANIA WHERE ID=? AND EMAIL=? AND USEYN='y'";
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, email);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Mania().setPwd(rs.getString("pwd"));
			}else {
				return null;
				}
			
		}catch(Exception e) {
			throw e;
			
		}finally {
			try { 
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
			}
	}
	
	//----------------------------------------------------아이디 찾기
		public Mania findId(String phone, String email) throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT ID FROM MANIA WHERE PHONE=? AND EMAIL=? AND USEYN='y'";
			
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, phone);
				stmt.setString(2, email);
				rs = stmt.executeQuery();
				if(rs.next()) {
					return new Mania().setId(rs.getString("id"));
				}else {
					return null;
					}
				
			}catch(Exception e) {
				throw e;
				
			}finally {
				try { 
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {}
				}
		}
		
		
		
		//------------------------------------------------------------등급 수정
		
		public int changeLevel(Mania mania) throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "UPDATE MANIA SET RATE=? WHERE ID=?";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, mania.getRate());
				stmt.setString(2, mania.getId());
				return stmt.executeUpdate();
			}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					
				}
			}
			
		}
		
		
		
		//----------------------------------------활동 회원 조회
		public List<Mania> useynList(String useyn) throws Exception {
			Connection conn =null;
			Statement stmt = null;
			ResultSet rs= null;
			List<Mania> manias = new ArrayList<>();
			try {
				conn = ds.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM Mania WHERE USEYN='"+useyn+"' ORDER BY NAME ASC");
						while(rs.next()) {
							manias.add(new Mania().setId(rs.getString(1)).setPwd(rs.getString(2)).setName(rs.getString(3))
									.setNick(rs.getString(4)).setEmail(rs.getString(5)).setZip_num(rs.getString(6))
									.setAddress(rs.getString(7)).setPhone(rs.getString(8)).setAd(rs.getString(9))
									.setRate(rs.getString(10)).setUseyn(rs.getString(11)).setIndate(rs.getTimestamp(12)));
						}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {if(rs !=null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();}catch(Exception e) {}
			}
			
			return manias;
		}
	
}
