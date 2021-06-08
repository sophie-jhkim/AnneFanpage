package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.Cart;
import dto.Orders;

public class OrderDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<Orders> listOrderById(String id, String result, int oseq){
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from v_order where id=? and result like '%"+result+"%' and oseq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, oseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Orders order = new Orders();
				order.setOdseq(rs.getInt("ODSEQ"));
				order.setOseq(rs.getInt("OSEQ"));
				order.setId(rs.getString("ID"));
				order.setPseq(rs.getInt("PSEQ"));
				order.setIndate(rs.getTimestamp("INDATE"));
				order.setQuantity(rs.getInt("QUANTITY"));
				order.setMname(rs.getString("MNAME"));
				order.setZip_num(rs.getString("ZIP_NUM"));
				order.setAddress(rs.getString("ADDRESS"));
				order.setPhone(rs.getString("PHONE"));
				order.setPname(rs.getString("PNAME"));
				order.setPrice2(rs.getInt("PRICE2"));
				order.setResult(rs.getString("RESULT"));
				orderList.add(order);
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
		return orderList;
		
	}
	
	//-------------------------------------------------------진행중인 주문내역
	
	public ArrayList<Integer> selectSeqOrderIng(String id){  
	ArrayList<Integer> oseqList = new ArrayList<Integer>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// distinct oseq 같은oseq가 여러개 있을 경우 하나로 표시
	String sql = "select distinct oseq from v_order where id=? and result='1' order by oseq desc";
	try {
		conn= ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			oseqList.add(rs.getInt(1));
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
	return oseqList;
}
	
	
	//-----------------------------------주문 히스토리
	public ArrayList<Integer> allOrder(String id){
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select distinct oseq from v_order where id=? order by oseq desc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				oseqList.add(rs.getInt(1));
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
		return oseqList;
	}
	
	//----------------------------------카트에서 오더로 넘기기
	public int insertOrder(ArrayList<Cart> cartList, String id) {
		int maxOseq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String insertOrder = "INSERT INTO ORDERS(ID) VALUES(?)";
			pstmt = conn.prepareStatement(insertOrder);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			String selectMaxOseq = "select max(oseq) from orders";
//			rs = pstmt.executeQuery(selectMaxOseq);
			pstmt = conn.prepareStatement(selectMaxOseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxOseq = rs.getInt(1);
			}
			for(Cart cart : cartList) {
				insertOrderDetail(cart, maxOseq);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return maxOseq;
		
	}
	
	public void insertOrderDetail(Cart cart, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			String insertOrderDetail = "INSERT INTO ORDER_DETAIL(oseq, pseq, quantity) values(?,?,?)";
			pstmt =conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cart.getPseq());
			pstmt.setInt(3, cart.getQuantity());
			pstmt.executeUpdate();
			pstmt.close();
			String updateCartResult = "update cart set result=2 where cseq=?";
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cart.getCseq());
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
	
	//--------------------------------------------------------------------관리자용 주문내역 모두 출력
//	public ArrayList<Integer> selectSeqOrder(){
//		ArrayList<Integer> orderList = new ArrayList<Integer>();
		public List<Orders> AdminOrderList(){ 
		List<Orders> orderList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from v_order order by odseq desc";
//		String sql = "select distinct oseq from v_order order by odseq desc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				orderList.add(rs.getInt(1));
				Orders order = new Orders();
				order.setOdseq(rs.getInt("ODSEQ"));
				order.setOseq(rs.getInt("OSEQ"));
				order.setId(rs.getString("ID"));
				order.setIndate(rs.getTimestamp("INDATE"));
				order.setPseq(rs.getInt("PSEQ"));
				order.setQuantity(rs.getInt("QUANTITY"));
				order.setMname(rs.getString("MNAME"));
				order.setZip_num(rs.getString("ZIP_NUM"));
				order.setAddress(rs.getString("ADDRESS"));
				order.setPhone(rs.getString("PHONE"));
				order.setPname(rs.getString("PNAME"));
				order.setPrice2(rs.getInt("PRICE2"));
				order.setResult(rs.getString("RESULT"));
				orderList.add(order);
				
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
		return orderList;
	}


		
		//----------------------------------------바로 주문
		public int directInsert(Orders orders, String id) {
//			public int directInsert(String id, int pseq, int qunatity) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int maxOseq = 0;
			try {
				conn = ds.getConnection();
				String insertOrder = "INSERT INTO ORDERS(ID) VALUES(?)";
				pstmt = conn.prepareStatement(insertOrder);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				pstmt.close();
				String selectMaxOseq = "select max(oseq) from orders";
				pstmt = conn.prepareStatement(selectMaxOseq);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					maxOseq = rs.getInt(1);
				}
				orderDetailDirect(orders, maxOseq);
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn !=null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return maxOseq;
		}
		
		//오더 바로 넣기
		
		public void orderDetailDirect(Orders orders, int maxOseq) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ds.getConnection();
				String insertOrderDetail = "INSERT INTO ORDER_DETAIL(oseq, pseq, quantity) values(?,?,?)";
				pstmt =conn.prepareStatement(insertOrderDetail);
				pstmt.setInt(1, maxOseq);
				pstmt.setInt(2, orders.getPseq());
				pstmt.setInt(3, orders.getQuantity());
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
		
		
		
	//관리자용 주문내용 다시
		public ArrayList<Integer> allOrderAdmin(){
			ArrayList<Integer> oseqList = new ArrayList<Integer>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql ="select distinct oseq from v_order order by oseq desc";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					oseqList.add(rs.getInt(1));
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
			return oseqList;
		}
		
		
		
		
		//test
		public ArrayList<Orders> listOrderAdmin(int oseq){
			ArrayList<Orders> orderList = new ArrayList<Orders>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from v_order where oseq=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, oseq);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Orders order = new Orders();
					order.setOdseq(rs.getInt("ODSEQ"));
					order.setOseq(rs.getInt("OSEQ"));
					order.setId(rs.getString("ID"));
					order.setPseq(rs.getInt("PSEQ"));
					order.setIndate(rs.getTimestamp("INDATE"));
					order.setQuantity(rs.getInt("QUANTITY"));
					order.setMname(rs.getString("MNAME"));
					order.setZip_num(rs.getString("ZIP_NUM"));
					order.setAddress(rs.getString("ADDRESS"));
					order.setPhone(rs.getString("PHONE"));
					order.setPname(rs.getString("PNAME"));
					order.setPrice2(rs.getInt("PRICE2"));
					order.setResult(rs.getString("RESULT"));
					orderList.add(order);
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
			return orderList;
			
		}
		
		//관리자 주문 상태 변경
		public int changeState(Orders order) throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
//			String sql = "UPDATE ORDER_DETAIL SET RESULT=? WHERE ODSEQ=?";
			String sql = "UPDATE ORDER_DETAIL SET RESULT='2' WHERE ODSEQ=?";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
//				stmt.setString(1, order.getResult());
				stmt.setInt(1, order.getOdseq());
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
}
	

