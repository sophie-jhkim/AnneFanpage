package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import dto.ZipCode;

public class ZipCodeDao {
	private DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<ZipCode> address(String dong) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ZipCode> list = new ArrayList<>();
		String sql ="SELECT * FROM ZIPCODE WHERE DONG LIKE '%"+dong+"%'";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipCode address = new ZipCode();
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setZipcode(rs.getString("zipcode"));
				address.setBungi(rs.getString("bunji"));
				list.add(address);
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
		return list;
	}

}
