package mvcmem.model;

import java.sql.*;
import java.util.Vector;
import javax.sql.*;
import javax.naming.*;

public class StudentDAO {

	// 싱글톤 생성
	private static StudentDAO instance = null;
	
	private StudentDAO() {}

	public static StudentDAO getInstance() {
		
		if(instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		
		return instance;
	}
		
	private Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
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
		
			String sql = "select * from student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) result = false;
			
		} catch(SQLException ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try{
					rs.close();
				}catch(SQLException ex){}
			
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
		
		return result;
	} // end idCheck
	
	// zipcodeRead (동으로 검색)
	public Vector<ZipCodeVO> zipcodeRead(String dong){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		
		try {
			
			conn = getConnection();
		
			String sql = "select * from zipcode where dong like '" +dong+ "%'" ;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeVO tempZipcode = new ZipCodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZipcode);			
			}
			
		} catch(SQLException ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try{
					rs.close();
				}catch(SQLException ex){}
			
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
		
		return vecList;
	} // end zipcodeRead
	
	//실제 데이터베이스 회원 데이터를 저장하기 위하여 메소드를 추가한다.
	public boolean memberInsert(StudentVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		
		try {
			
			conn = getConnection();
			
			String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
						
			int count = pstmt.executeUpdate();
			if(count > 0) flag = true;
					
		} catch(SQLException ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try{
					rs.close();
				}catch(SQLException ex){}
			
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
		
		return flag;
	} // end 메소드
	
	
	/*
	 * 데이터베이스에서 아이디와 비밀번호를 비교하여 그 결과를 정수형으로 리턴해주는 메소드
	 * 1:로그인 성공, 0:비밀번호 오류, -1:아이디없음 
	 */
	public int loginCheck(String id, String pass) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1;
		
		try {
			
			conn = getConnection(); // db연결
			
			// id로 pass 조회
			String sql = "select pass from student where id=?"; // ? : 바인딩변수
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // dbPass와 입력한 비밀번호 일치확인
				String dbPass = rs.getString("pass"); // pass : 컬럼명
				if(pass.equals(dbPass)) check = 1; // 비밀번호 일치
				else check = 0; // 비밀번호 오류
			}
			
			
		} catch(Exception ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try{
					rs.close();
				}catch(SQLException ex){}
			
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
		
		return check;
	} // end loginCheck
	
	
	/* 정보수정 버튼을 클릭하면 현재 로그인한 회원을 정보를 수정 할 수 있도록 화면에 보여주어야 한다.
	 * 
	 * 세션에 저장된 아이디를 가지고 회원정보를 얻어오는 메소드를 이용하여 가져옴
	 */
	public StudentVO getMember(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StudentVO vo = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 해당 아이디에 대한 회원이 존재한다면
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
			
		} catch(Exception ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try{
					rs.close();
				}catch(SQLException ex){}
			
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
		
		return vo;
	} // end getMember
	
	
	/*
	 * 정보수정 버튼을 클릭했을 경우 데이터베이스에서 수정처리를 해야한다
	 * 정보수정 처리를 해 줄 메소드를 구현
	 */
	public void updateMember(StudentVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "update student set pass=?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?, address1=?, address2=? where id=?";
			
			pstmt = conn.prepareStatement(sql); // 쿼리 실행

			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			
			pstmt.executeUpdate();
			
		} catch(Exception ss) {
			ss.printStackTrace();
		} finally {
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
	} // end updateMember
	
	
	/*
	 * 회원탈퇴 버튼을 클릭했을 경우 실제 데이터베이스에서 회원데이터가 삭제되어야 함
	 * 데이터베이스에서 회원을 삭제처리 할 메소드를 구현
	 */
	public int deleteMember(String id, String pass) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPass = ""; // 데이터베이스에서 저장되어 있는 비밀번호
		int result = -1; // 아이디 없을 경우
		
		try {
			
			conn = getConnection();
			
			String sql = "select pass from student where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // 바인딩변수 처리
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPass = rs.getString("pass");
				if(dbPass.equals(pass)) { // 본인맞음
					sql = "delete from student where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1; // 회원탈퇴 성공
				}else { // 본인확인 실패
					result = 0; // 비밀번호 오류
				}
			}
			
		} catch(Exception ss) {
			ss.printStackTrace();
		} finally {
			if(rs != null)
				try{
					rs.close();
				}catch(SQLException ex){}
			
			if(pstmt != null)
				try{
					pstmt.close();
				}catch(SQLException ex){}
			
			if(conn != null)
				try{
					conn.close();
				}catch(SQLException ex){}
		}
		
		return result;
	} // end deleteMember
	
	
}
