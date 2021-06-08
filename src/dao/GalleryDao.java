package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Board;
import dto.Gallery;


public class GalleryDao {
	
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	//--------------------------------------- 리스트
	public List<Gallery> galleryList() throws Exception{
		List<Gallery> galleryList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PHOTO ORDER BY GSEQ DESC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Gallery gallery = new Gallery();
				gallery.setGseq(rs.getInt("gseq"));
				gallery.setTitle(rs.getString("title"));
				gallery.setId(rs.getString("id"));
				gallery.setContent(rs.getString("content"));
				gallery.setImg(rs.getString("img"));
				gallery.setHit(rs.getInt("hit"));
				gallery.setNick(rs.getString("nick"));
				gallery.setIndate(rs.getTimestamp("indate"));
				galleryList.add(gallery);
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
		
		return galleryList;
	}
	
	//조회수 증가
	public Gallery hit(Gallery gallery, int gseq) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String updateHit = "Update PHOTO SET HIT=HIT+1 Where gseq='"+gseq+"'";
			pstmt = conn.prepareStatement(updateHit);
			pstmt.executeUpdate();
			pstmt.close();
			String sql="SELECT GSEQ, TITLE, CONTENT, IMG, ID, NICK, HIT, INDATE"+" FROM PHOTO WHERE GSEQ='"+gseq+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Gallery()
						.setGseq(rs.getInt("gseq"))
						.setTitle(rs.getString("title"))
						.setContent(rs.getString("content"))
						.setImg(rs.getString("img"))
						.setId(rs.getString("id"))
						.setNick(rs.getString("nick"))
						.setHit(rs.getInt("hit"))
						.setIndate(rs.getTimestamp("indate"));
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {}
		}
		return gallery;
	}
	
	public int insertPhoto(Gallery gallery) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		String sql = "INSERT INTO PHOTO(TITLE, CONTENT, IMG, ID, NICK) VALUES(?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getContent());
			pstmt.setString(3, gallery.getImg());
			pstmt.setString(4, gallery.getId());
			pstmt.setString(5, gallery.getNick());
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
	
	//삭제
	public void delete(int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PHOTO WHERE gseq=?";
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gseq);
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
	
	public Gallery selectOne(int gseq) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			String sql="SELECT GSEQ, TITLE, CONTENT, ID, NICK, HIT, INDATE"+" FROM PHOTO WHERE GSEQ='"+gseq+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return new Gallery()
						.setGseq(rs.getInt("gseq"))
						.setTitle(rs.getString("title"))
						.setContent(rs.getString("content"))
						.setId(rs.getString("id"))
						.setNick(rs.getString("nick"))
						.setHit(rs.getInt("hit"))
						.setIndate(rs.getTimestamp("indate"));
			}

		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(rs !=null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {}
			
		}
		return null;
	}
	
	public int update(Gallery gallery) throws Exception{
		Connection conn= null;
		PreparedStatement stmt= null;
		String sql="UPDATE PHOTO SET TITLE=?, CONTENT=?, NICK=?, IMG=?, ID=? WHERE GSEQ=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, gallery.getTitle());
			stmt.setString(2, gallery.getContent());
			stmt.setString(3, gallery.getNick());
			stmt.setString(4, gallery.getImg());
			stmt.setString(5, gallery.getId());
			stmt.setInt(6, gallery.getGseq());
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
	
	
	

}
