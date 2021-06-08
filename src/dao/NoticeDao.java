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
import dto.Notice;

public class NoticeDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<Notice> listNotice() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Notice> noticeList = new ArrayList<>();
		String sql = "SELECT * FROM NOTICE ORDER BY NSEQ DESC";
		try {
			conn=ds.getConnection();
			stmt=conn.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNseq(rs.getInt("nseq"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setId(rs.getString("id"));
				notice.setNick(rs.getString("nick"));
				notice.setHit(rs.getInt("hit"));
				notice.setIndate(rs.getTimestamp("indate"));
				noticeList.add(notice);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return noticeList;
		
	}
	//----------hit 올리고 상세보기
	public Notice hit(Notice notice, int nseq) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String updateHit = "Update NOTICE SET HIT=HIT+1 Where nseq='"+nseq+"'";
			pstmt = conn.prepareStatement(updateHit);
			pstmt.executeUpdate();
			pstmt.close();
			String sql="SELECT NSEQ, TITLE, CONTENT, ID, NICK, HIT, INDATE"+" FROM NOTICE WHERE NSEQ='"+nseq+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Notice()
						.setNseq(rs.getInt("nseq"))
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
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {}
		}
		return notice;
	}
	
	//---------------------------------------------공지 삭제
	public void delete(int nseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NOTICE WHERE nseq=?";
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nseq);
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
	
	//-------------------------------------공지 작성
	
	public int insertNotice(Notice notice) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = -1;
		String sql="insert into notice(title, content, id, nick) values(?,?,?,?)";
		try {
			conn = ds.getConnection();
			
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, notice.getTitle());
			stmt.setString(2, notice.getContent());
			stmt.setString(3, notice.getId());
			stmt.setString(4, notice.getNick());
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {if(stmt != null) stmt.close();
			 if(conn !=null) conn.close();
		}catch(Exception e) {}
	}
	return result;
		
	}
	//공지 선택 보기
	public Notice selectOne(int nseq) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			String sql="SELECT NSEQ, TITLE, CONTENT, ID, NICK, HIT, INDATE"+" FROM Notice WHERE NSEQ='"+nseq+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return new Notice()
						.setNseq(rs.getInt("nseq"))
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
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {}
			
		}
		return null;
	}
	//-------------------------------------공지 수정
	public int update(Notice notice) throws Exception{
		Connection conn= null;
		PreparedStatement stmt= null;
		String sql="UPDATE Notice SET TITLE=?, CONTENT=?, NICK=?, ID=? WHERE NSEQ=?";
		try 
		{
		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, notice.getTitle());
		stmt.setString(2, notice.getContent());
		stmt.setString(3, notice.getNick());
		stmt.setString(4, notice.getId());
		stmt.setInt(5, notice.getNseq());
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
