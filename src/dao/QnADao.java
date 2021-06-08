package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Notice;
import dto.QnA;

public class QnADao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
//================================================================================QnA List
	public ArrayList<QnA> listQna(String id){
		ArrayList<QnA> qnaList = new ArrayList<QnA>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from qna where id=? order by qseq desc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnA qna = new QnA();
				qna.setQseq(rs.getInt("QSEQ"));
				qna.setSubject(rs.getString("SUBJECT"));
				qna.setContent(rs.getString("CONTENT"));
				qna.setReply(rs.getString("REPLY"));
				qna.setId(rs.getString("ID"));
				qna.setRep(rs.getString("REP"));
				qna.setIndate(rs.getTimestamp("INDATE"));
				qnaList.add(qna);
				
			}
			
		}catch(Exception e){
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
		
		
		return qnaList;
		
	}
	
	//===================================================================================문의하기
	
	public void insertQna(QnA qna, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into QNA(SUBJECT, CONTENT, ID) VALUES(?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, qna.getId());
			pstmt.executeUpdate();
			
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
		
	}
//==========================================================================detail Qna
	public QnA detailQna(String id, int qseq) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from QNA where ID=? and qseq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, qseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new QnA()
				.setQseq(rs.getInt("QSEQ"))
				.setSubject(rs.getString("SUBJECT"))
				.setContent(rs.getString("CONTENT"))
				.setReply(rs.getString("REPLY"))
				.setId(rs.getString("ID"))
				.setRep(rs.getString("REP"))
				.setIndate(rs.getTimestamp("INDATE"));
				
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
		return null;
	}
	
	
	//================================================================================관리자용 전체QnA List
		public List<QnA> QnaAllList() throws Exception {
			List<QnA> qnaAll = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql ="select * from qna order by qseq desc";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					QnA qna = new QnA();
					qna.setQseq(rs.getInt("QSEQ"));
					qna.setSubject(rs.getString("SUBJECT"));
					qna.setContent(rs.getString("CONTENT"));
					qna.setReply(rs.getString("REPLY"));
					qna.setId(rs.getString("ID"));
					qna.setRep(rs.getString("REP"));
					qna.setIndate(rs.getTimestamp("INDATE"));
					qnaAll.add(qna);
					
				}
				
			}catch(Exception e){
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
			
			
			return qnaAll;
			
		}
		
		
		//==========================================================================관리자용 detail Qna
		public QnA adminDetailQna(int qseq) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			QnA qna = null;
			String sql = "select * from QNA where qseq=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qseq);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					qna = new QnA();
					qna.setQseq(rs.getInt("QSEQ"));
					qna.setSubject(rs.getString("SUBJECT"));
					qna.setContent(rs.getString("CONTENT"));
					qna.setReply(rs.getString("REPLY"));
					qna.setId(rs.getString("ID"));
					qna.setRep(rs.getString("REP"));
					qna.setIndate(rs.getTimestamp("INDATE"));
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
			return qna;
		}
		
		//================================================================================답변해주기
		
		public int answerQna(QnA qna, int qseq) throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "update QNA set reply=?, rep='"+2+"' where qseq='"+qseq+"'";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, qna.getReply());
				return stmt.executeUpdate();
				
			}catch(Exception e) {
				throw e;
			}finally {
				try {
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		public QnA selectOne(int qseq) throws Exception{
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = ds.getConnection();
				stmt = conn.createStatement();
				String sql="SELECT QSEQ, Subject, CONTENT, ID, INDATE"+" FROM QNA WHERE QSEQ='"+qseq+"'";
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					return new QnA()
							.setQseq(rs.getInt("qseq"))
							.setSubject(rs.getString("subject"))
							.setContent(rs.getString("content"))
							.setId(rs.getString("id"))
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
		
		
		//-------------------------------------------------문의 내역 수정
		public int update(QnA qna) throws Exception{
			Connection conn= null;
			PreparedStatement stmt= null;
			String sql="UPDATE QNA SET Subject=?, CONTENT=? WHERE QSEQ=?";
			try 
			{
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qna.getSubject());
			stmt.setString(2, qna.getContent());
			stmt.setInt(3, qna.getQseq());
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
		//------------------------------------------문의 삭제
		public void delete(int qseq) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM QNA WHERE qseq=?";
			try {
				conn=ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qseq);
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
