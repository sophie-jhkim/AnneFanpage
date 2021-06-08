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

import dto.Gallery;
import dto.Goods;
import dto.Mania;
import dto.ZipCode;

public class GoodsDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds =ds;
	}
	
	public Goods selectOne(int pseq) throws Exception{
		Goods goods = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT pseq, name, kind, price1, price2, price3, content, img, useyn, bestyn, indate"
				+ " FROM GOODS WHERE pseq='"+pseq+"'";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				goods = new Goods();
				goods.setPseq(rs.getInt("pseq"));
				goods.setName(rs.getString("name"));
				goods.setKind(rs.getInt("kind"));
				goods.setPrice1(rs.getInt("price1"));
				goods.setPrice2(rs.getInt("price2"));
				goods.setPrice3(rs.getInt("price3"));
				goods.setContent(rs.getString("content"));
				goods.setImg(rs.getString("img"));
				goods.setUseyn(rs.getString("useyn"));
				goods.setBestyn(rs.getString("bestyn"));
				goods.setIndate(rs.getTimestamp("indate"));
				return goods;
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
		return null;
	}	
	
	//--------------------------------------- 심플 굿즈 리스트
	public List<Goods> goodsSimpleList() throws Exception{
		List<Goods> goodsList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM GOODS ORDER BY PSEQ DESC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setPseq(rs.getInt("pseq"));
				goods.setName(rs.getString("name"));
				goods.setKind(rs.getInt("kind"));
				goods.setPrice1(rs.getInt("price1"));
				goods.setPrice2(rs.getInt("price2"));
				goods.setPrice3(rs.getInt("price3"));
				goods.setContent(rs.getString("content"));
				goods.setImg(rs.getString("img"));
				goods.setUseyn(rs.getString("useyn"));
				goods.setBestyn(rs.getString("bestyn"));
				goods.setIndate(rs.getTimestamp("indate"));
				goodsList.add(goods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		
		return goodsList;
	}
	
	
	//--------------------------------------- 제품 리스트 (페이징 적용)
	public List<Goods> goodsList(int page, int cnt) throws Exception{
		List<Goods> goodsList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int page2 = (page -1)*cnt;
		String sql = "SELECT * FROM GOODS ORDER BY PSEQ DESC LIMIT ?,?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page2);
			pstmt.setInt(2, cnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setPseq(rs.getInt("pseq"));
				goods.setName(rs.getString("name"));
				goods.setKind(rs.getInt("kind"));
				goods.setPrice1(rs.getInt("price1"));
				goods.setPrice2(rs.getInt("price2"));
				goods.setPrice3(rs.getInt("price3"));
				goods.setContent(rs.getString("content"));
				goods.setImg(rs.getString("img"));
				goods.setUseyn(rs.getString("useyn"));
				goods.setBestyn(rs.getString("bestyn"));
				goods.setIndate(rs.getTimestamp("indate"));
				goodsList.add(goods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		
		return goodsList;
	}
	
	//-----------------------------------------------best 상품
	public List<Goods> bestGoods(){
		List<Goods> bestGoods = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM v_best_goods order by pseq asc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		while(rs.next()) {
			Goods goods = new Goods();
			goods.setPseq(rs.getInt("pseq"));
			goods.setName(rs.getString("name"));
			goods.setPrice2(rs.getInt("price2"));
			goods.setImg(rs.getString("img"));
			bestGoods.add(goods);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return bestGoods;
		
	}
	
	//--------------------------------------- 카테고리 별 제품 리스트
		public List<Goods> kindList(int kind) throws Exception{
			List<Goods> goodsList = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM GOODS WHERE KIND='"+kind+"' ORDER BY PSEQ DESC ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Goods goods = new Goods();
					goods.setPseq(rs.getInt("pseq"));
					goods.setName(rs.getString("name"));
					goods.setKind(rs.getInt("kind"));
					goods.setPrice1(rs.getInt("price1"));
					goods.setPrice2(rs.getInt("price2"));
					goods.setPrice3(rs.getInt("price3"));
					goods.setContent(rs.getString("content"));
					goods.setImg(rs.getString("img"));
					goods.setUseyn(rs.getString("useyn"));
					goods.setBestyn(rs.getString("bestyn"));
					goods.setIndate(rs.getTimestamp("indate"));
					goodsList.add(goods);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {}
			}
			
			return goodsList;
		}
		//-------------------------------선택 삭제
		public void deleteGoods(int pseq) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM GOODS WHERE PSEQ=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pseq);
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		//---------------------------------------------------재고 및 베스트 상품 변경
		
		public int change(Goods goods) throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "UPDATE GOODS SET USEYN=?, BESTYN=? WHERE PSEQ=?";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, goods.getUseyn());
				stmt.setString(2, goods.getBestyn());
				stmt.setInt(3, goods.getPseq());
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
		
		//----------------------------------------상품 등록
		public int insert(Goods goods) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = -1;
			String sql = "INSERT INTO Goods(name, kind, price1, price2, price3, content, img, bestyn) VALUES(?,?,?,?,?,?,?,?)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, goods.getName());
				pstmt.setInt(2, goods.getKind());
				pstmt.setInt(3, goods.getPrice1());
				pstmt.setInt(4, goods.getPrice2());
				pstmt.setInt(5, goods.getPrice3());
				pstmt.setString(6, goods.getContent());
				pstmt.setString(7, goods.getImg());
				pstmt.setString(8, goods.getBestyn());
				result = pstmt.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstmt != null) {pstmt.close();}
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
		}

		
		//-------------------------------------------------------제품 검색
		public List<Goods> search(String name) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Goods> goodsList = new ArrayList<>();
			String sql ="SELECT * FROM GOODS WHERE NAME LIKE '%"+name+"%'";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Goods goods = new Goods();
					goods.setPseq(rs.getInt("pseq"));
					goods.setName(rs.getString("name"));
					goods.setKind(rs.getInt("kind"));
					goods.setPrice1(rs.getInt("price1"));
					goods.setPrice2(rs.getInt("price2"));
					goods.setPrice3(rs.getInt("price3"));
					goods.setContent(rs.getString("content"));
					goods.setImg(rs.getString("img"));
					goods.setUseyn(rs.getString("useyn"));
					goods.setBestyn(rs.getString("bestyn"));
					goods.setIndate(rs.getTimestamp("indate"));
					goodsList.add(goods);
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
			return goodsList;
		}
		
		public int update(Goods goods) throws Exception{
			Connection conn= null;
			PreparedStatement stmt= null;
			String sql="UPDATE GOODS SET NAME=?, CONTENT=?, KIND=?, PRICE1=?, PRICE2=?,"
					+ "PRICE3=?, IMG=?, BESTYN=?, USEYN=? WHERE PSEQ=?";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, goods.getName());
				stmt.setString(2, goods.getContent());
				stmt.setLong(3, goods.getKind());
				stmt.setInt(4, goods.getPrice1());
				stmt.setInt(5, goods.getPrice2());
				stmt.setInt(6, goods.getPrice3());
				stmt.setString(7, goods.getImg());
				stmt.setString(8, goods.getBestyn());
				stmt.setString(9, goods.getUseyn());
				stmt.setInt(10, goods.getPseq());
				return stmt.executeUpdate();
			}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {}
			}
			
		}
		
		//-----------------------------------------------페이징용
		public int getAllCount() throws Exception{
			Connection conn= null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			int count = 0;
			String sql = "Select count(*) as count from Goods";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt("count");
				}
				
			}catch(Exception e) {
				throw e;
			}finally {
				try {
					if (stmt != null) stmt.close();
					if (conn != null)conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			return count;
		}
		
}
