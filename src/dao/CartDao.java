package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import dto.Cart;

public class CartDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	//--------------------------------------------------------장바구니 리스트
	public ArrayList<Cart> listCart(String id){
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from v_cart where id=? order by cseq desc";
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Cart cart = new Cart();
				cart.setCseq(rs.getInt("cseq"));
				cart.setId(rs.getString("id"));
				cart.setPseq(rs.getInt("pseq"));
				cart.setMname(rs.getString("mname"));
				cart.setPname(rs.getString("pname"));
				cart.setImg(rs.getString("img"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setIndate(rs.getTimestamp("indate"));
				cart.setPrice2(rs.getInt("price2"));
				cartList.add(cart);
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
		return cartList;
	}
	//-------------------------------------------------장바구니 담기
	public void insert(Cart cart) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CART(ID, PSEQ, QUANTITY) VALUES(?,?,?)";
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cart.getId());
			pstmt.setInt(2, cart.getPseq());
			pstmt.setInt(3, cart.getQuantity());
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
	
	//-------------------------------------------------선택 삭제
	public void deleteCart(int cseq){
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "DELETE FROM CART WHERE CSEQ=?";
	try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cseq);
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
