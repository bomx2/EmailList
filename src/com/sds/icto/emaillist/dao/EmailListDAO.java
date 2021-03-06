package com.sds.icto.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.emaillist.vo.EmailListVO;

public class EmailListDAO {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}

	public void insert(EmailListVO vo) throws ClassNotFoundException,
			SQLException {
		// Connection 생성
		Connection conn = getConnection();

		// 2. Statement(SQL) 준비
		String sql = "insert into email_list values(email_list_no_seq.nextval, ?, ?, ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3.binding
		pstmt.setString(1, vo.getFirstname());
		pstmt.setString(2, vo.getLastname());
		pstmt.setString(3, vo.getEmail());

		// 4. query 실행
		pstmt.executeUpdate();

		// 5. 자원정리
		if (pstmt != null) {
			pstmt.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public void delete(Long id) throws ClassNotFoundException, SQLException {

	}

	public void delete() throws ClassNotFoundException, SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. query 실행
		String sql = "delete from email_list";
		stmt.executeUpdate(sql);
		// 4. 자원 정리
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public List<EmailListVO> fetchList() throws ClassNotFoundException,
			SQLException {
		List<EmailListVO> list = new ArrayList<EmailListVO>();
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. SQL문 실행
		String sql = "select * from email_list";
		ResultSet rs = stmt.executeQuery(sql);
		// 4. 결과 처리
		while (rs.next()) {
			Long no = rs.getLong(1);
			String firstname = rs.getString(2);
			String lastname = rs.getString(3);
			String email = rs.getString(4);
			EmailListVO vo = new EmailListVO();
			vo.setNo(no);
			vo.setFirstname(firstname);
			vo.setLastname(lastname);
			vo.setEmail(email);
			list.add(vo);
		}
		// 5. 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return list;
	}

}
