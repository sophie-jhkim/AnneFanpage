package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.BReply;
import dto.PReply;

public class BReplyDao {
	public DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<BReply> listRep(int bseq){
		List<BReply> replyList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
//		int bseq = 
		ResultSet rs = null;
		String sql = "SELECT * FROM B_REPLY WHERE BSEQ='"+bseq+"' ORDER BY RSEQ DESC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				BReply breply = new BReply();
				breply.setBseq(rs.getInt("bseq"));
				breply.setRseq(rs.getInt("rseq"));
				breply.setId(rs.getString("id"));
				breply.setContent(rs.getString("content"));
				breply.setNick(rs.getString("nick"));
				breply.setIndate(rs.getTimestamp("indate"));
				replyList.add(breply);
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
		return replyList;
	}
	
	public int insert(BReply breply) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =-1;
		String sql ="INSERT INTO B_REPLY(ID, NICK, CONTENT, BSEQ) VALUES(?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, breply.getId());
			pstmt.setString(2, breply.getNick());
			pstmt.setString(3, breply.getContent());
			pstmt.setInt(4, breply.getBseq());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	
	public void delete(int rseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM B_REPLY WHERE RSEQ=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rseq);
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
	
	public int update(BReply breply) throws Exception{
		Connection conn= null;
		PreparedStatement stmt= null;
		String sql="UPDATE B_REPLY SET CONTENT=?, NICK=? WHERE RSEQ=?";
		try 
		{
		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, breply.getContent());
		stmt.setString(2, breply.getNick());
//		stmt.setInt(3, breply.getBseq());
		stmt.setInt(3, breply.getRseq());
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
	
	
	public BReply selectOne(int rseq) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			String sql = "Select RSEQ, BSEQ, CONTENT, ID, NICK, INDATE FROM B_REPLY WHERE RSEQ='"+rseq+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return new BReply()
				.setRseq(rs.getInt("rseq"))
				.setBseq(rs.getInt("bseq"))
				.setContent(rs.getString("content"))
				.setId(rs.getString("id"))
				.setNick(rs.getString("nick"))
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
}
