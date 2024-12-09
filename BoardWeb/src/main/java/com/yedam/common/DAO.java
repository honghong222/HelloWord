package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	// 쿼리실행을 위한 필드 선언
	public Connection conn = null;
	public PreparedStatement psmt;
	public ResultSet rs;

		// 연결해제
		public void disConnect() {
			try {
				if (conn != null)
					conn.close();
				if (psmt != null)
					psmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("연결 중 에러.");
				e.printStackTrace();
			}
		}

		public Connection getConn() {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드.
				// Connection 객체.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "prog");
			} catch (Exception e) {
				System.out.println("연결 중 에러.");
				e.printStackTrace();
			}
			return conn; // connection 객체 반환.
		}
}