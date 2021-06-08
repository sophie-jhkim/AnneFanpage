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

public class PReplyDao {
	public DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	
	//---------------------------------------갤러리 댓글
	public List<PReply> listRep(int gseq){
		List<PReply> replyList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM P_REPLY WHERE GSEQ='"+gseq+"' ORDER BY RSEQ DESC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				PReply preply = new PReply();
				preply.setGseq(rs.getInt("gseq"));
				preply.setRseq(rs.getInt("rseq"));
				preply.setId(rs.getString("id"));
				preply.setContent(rs.getString("content"));
				preply.setNick(rs.getString("nick"));
				preply.setIndate(rs.getTimestamp("indate"));
				replyList.add(preply);
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
	
	public int insert(PReply preply) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =-1;
		String sql ="INSERT INTO P_REPLY(ID, NICK, CONTENT, GSEQ) VALUES(?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, preply.getId());
			pstmt.setString(2, preply.getNick());
			pstmt.setString(3, preply.getContent());
			pstmt.setInt(4, preply.getGseq());
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
		String sql = "DELETE FROM P_REPLY WHERE RSEQ=?";
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
	
	
	
	public PReply selectOne(int rseq) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			String sql = "Select RSEQ, GSEQ, CONTENT, ID, NICK, INDATE FROM P_REPLY WHERE RSEQ='"+rseq+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return new PReply()
				.setRseq(rs.getInt("rseq"))
				.setGseq(rs.getInt("gseq"))
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

	
	public int update(PReply preply) throws Exception{
		Connection conn= null;
		PreparedStatement stmt= null;
		String sql="UPDATE P_REPLY SET CONTENT=?, NICK=? WHERE RSEQ=?";
		try 
		{
		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, preply.getContent());
		stmt.setString(2, preply.getNick());
//		stmt.setInt(3, preply.getBseq());
		stmt.setInt(3, preply.getRseq());
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
