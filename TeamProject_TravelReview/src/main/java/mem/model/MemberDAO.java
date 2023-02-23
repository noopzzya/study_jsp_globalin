package mem.model;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class MemberDAO {

	// 싱글톤 생성
	private static MemberDAO instance = null;
	
	public MemberDAO() {}
	
	// 싱글톤 객체 생성
	public static MemberDAO getInstance() {
	
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	
	private Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();			
		} catch (Exception e) {
			System.out.println("Connection 생성 실패!");
		}
		return conn;
	}
	
	// idCheck
	public boolean idCheck(String id) {
		
		boolean result = true;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) result = false;
			
		} catch (SQLException ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try {
					rs.close();
				}catch (SQLException ex) {}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
				
		return result;
	} // end idCheck
	
}
