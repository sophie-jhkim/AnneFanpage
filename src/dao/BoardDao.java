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

import dto.Board;
import dto.Goods;

public class BoardDao {
	private DataSource ds;
	public void setDateSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<Board> listBoard() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Board> board = new ArrayList<>();
		String sql = "SELECT BSEQ, SUBJECT, CONTENT, ID, NICK, HIT, INDATE "
				+ "FROM BOARD ORDER BY BSEQ DESC";
		try {
				conn = ds.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
			while(rs.next()) {
				board.add(new Board()
						.setBseq(rs.getInt("bseq"))
						.setSubject(rs.getString("subject"))
						.setContent(rs.getString("content"))
						.setId(rs.getString("id"))
						.setNick(rs.getString("nick"))
						.setHit(rs.getInt("hit"))
						.setIndate(rs.getTimestamp("indate")));
			}
			return board;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try { if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				}catch(Exception e) {}
		}
		return null;
	} 
	//조회수 증가
	public Board hit(Board board, int bseq) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String updateHit = "Update BOARD SET HIT=HIT+1 Where bseq='"+bseq+"'";
			pstmt = conn.prepareStatement(updateHit);
//			pstmt.setInt(1, board.getHit());
//			pstmt.setInt(2, board.getBseq());
			pstmt.executeUpdate();
			pstmt.close();
			String sql="SELECT BSEQ, SUBJECT, CONTENT, ID, NICK, HIT, INDATE"+" FROM BOARD WHERE BSEQ='"+bseq+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Board()
						.setBseq(rs.getInt("bseq"))
						.setSubject(rs.getString("subject"))
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
		return board;
	}
	//게시글 보기
	public Board selectOne(int bseq) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			String sql="SELECT BSEQ, SUBJECT, CONTENT, ID, NICK, HIT, INDATE"+" FROM BOARD WHERE BSEQ='"+bseq+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return new Board()
						.setBseq(rs.getInt("bseq"))
						.setSubject(rs.getString("subject"))
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
	//-------------------------------------게시글 작성
	
	public int insertBoard(Board board) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = -1;
		String sql="insert into board(subject, content, id, nick) values(?,?,?,?)";
		try {
			conn = ds.getConnection();
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, board.getSubject());
			stmt.setString(2, board.getContent());
			stmt.setString(3, board.getId());
			stmt.setString(4, board.getNick());
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
	//-------------------------------------게시글 수정
	public int update(Board board) throws Exception{
		Connection conn= null;
		PreparedStatement stmt= null;
		String sql="UPDATE BOARD SET SUBJECT=?, CONTENT=? WHERE BSEQ=?";
		try 
		{
		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getSubject());
		stmt.setString(2, board.getContent());
		stmt.setInt(3, board.getBseq());
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
	
	//---------------------------------------------게시글 삭제
	public void delete(int bseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE bseq=?";
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bseq);
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
	
	
	//------------------------------------------------------- 검색
	public List<Board> search(String name) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> board = new ArrayList<>();
		String sql ="SELECT * FROM BOARD WHERE subject LIKE '%"+name+"%'";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.add(new Board()
						.setBseq(rs.getInt("bseq"))
						.setSubject(rs.getString("subject"))
						.setContent(rs.getString("content"))
						.setId(rs.getString("id"))
						.setNick(rs.getString("nick"))
						.setHit(rs.getInt("hit"))
						.setIndate(rs.getTimestamp("indate")));
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
		return board;
	}
}
