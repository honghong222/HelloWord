package com.yedam.jdbc.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/* 
 * DAO: Data Access Object.
 * 입력, 수정, 삭제, 조회(목록, 단건조회)
 */

public class StudentDAO extends DAO {
	
	// login() => 반환:boolean, 매개값: id, pw
	public boolean login(String id, String pw) {
		getConn();
		String sql = "select * from tbl_member where member_id = ? and member_pw = ?";
		
		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			while(rs.next()) {
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			disConnect(); // 연결 해제.
		}
		// 반환값.
		return false;
	}
		
	
	// 상세조회. 반환값 : boolean, 매개값 : Student 메소드 : selectStudent.
	public Student selectStudent(String sno) {
		getConn(); // 연결.
		// 조회 결과를 반환.
		String sql = "select * from tbl_student where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno); // 파라미터(?) 값 지정.
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student std = new Student(); // 인스턴스 생성.
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setStdPhone(rs.getString("std_phone"));
				std.setEngScore(rs.getInt("eng_score"));
				std.setMathScore(rs.getInt("math_score"));
				return std;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	
	// 점수등록. 반환값 : boolean, 매개값 : Student, 메소드 : updateStudent.
	public boolean updateStudent(Student std) {
		getConn();
		String sql = "update tbl_student set eng_score = ?"
				+ "                       , math_score = ? "
				+ "    where                    std_no = ?";
		// 조회 결과를 반환.
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore()); // std_name
			psmt.setInt(2, std.getMathScore()); // std_phone
			psmt.setString(3, std.getStdNo()); // std_no
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true; // 정상등록.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	// 등록(번호, 이름, 연락처). 반환값 : boolean, 매개값 : Student, 메소드 : insertStudent.
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no,"
				+ "                            std_name,"
				+ "                               std_phone)"
				+ "                    values(?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo()); // std_no
			psmt.setString(2, std.getStdName()); // std_name
			psmt.setString(3, std.getStdPhone()); // std_phone
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true; // 정상등록.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return false;
	}

	// 학생목록. 
	// 검색조건(학생이름, 연락처, 영어, 수학 검색조건 + 정렬 조건 ) 
	public ArrayList<Student> studentList(Search search) {
		getConn(); // 연결.
		// 조회 결과를 반환.
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "select   std_no "
				+ "           , std_name"
				+ "           , std_phone"
				+ "           ,  eng_score"
				+ "           ,  math_score"
		  //    + "            , to_char(creation_date,'yyyy-mm-dd hh24:mi:ss') "
				+ "            ,creation_date"
				+ "    from tbl_student "
				+ "    where    std_name like '%'||?||'%'"
				+ "         and eng_score >= ? ";
		if(search.getOrderBy().equals("std_no")) {
			sql += " order by std_no";
		} else if (search.getOrderBy().equals("std_name")) {
			sql += " order by std_name";
		}
		
		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.
			psmt.setString(1, search.getName());
			psmt.setString(2, search.getPhone());
			psmt.setInt(3, search.getEngScore());
			rs = psmt.executeQuery();

			// 반복 ArrayList에 담는 작업.
			while (rs.next()) {
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setcreationDate(rs.getDate("creationDate"));

				studList.add(stud); // ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			disConnect(); // 연결 해제.
		}
		// 반환값.
		return studList;
	}

}
