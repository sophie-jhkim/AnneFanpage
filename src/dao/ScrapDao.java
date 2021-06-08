package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.Cart;
import dto.Scrap;

public class ScrapDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	
	public ArrayList<Scrap> listScrap(String id){
		ArrayList<Scrap> scrapList = new ArrayList<Scrap>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from v_scrap where id=? order by sseq desc";
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Scrap scrap= new Scrap();
				scrap.setSseq(rs.getInt("sseq"));
				scrap.setId(rs.getString("id"));
				scrap.setGseq(rs.getInt("gseq"));
				scrap.setGtitle(rs.getString("gtitle"));
				scrap.setImg(rs.getString("img"));
				scrap.setIndate(rs.getTimestamp("indate"));
				scrapList.add(scrap);
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
		return scrapList;
	}
	
	
	public void insert(Scrap scrap) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO Scrap(ID, GSEQ) VALUES(?,?)";
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getGseq());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void deleteScrap(int sseq){
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "DELETE FROM SCRAP WHERE SSEQ=?";
	try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sseq);
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
}
