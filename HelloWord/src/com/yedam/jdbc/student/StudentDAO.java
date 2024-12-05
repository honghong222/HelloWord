package com.yedam.jdbc.student;

import java.sql.SQLException;
import java.util.ArrayList;

//
//DAO: Date Access Object
//입력 수정 삭제 조회(목록,단건)
//
public class StudentDAO extends DAO {

	
	//상세조회
	public Student selectStudent(String sno){
		getConn();
		String sql = "select * "
				+ "from tbl_student"
				+ "where std_no = ?";
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, sno);//파라미터 값 지정
		rs = psmt.executeQuery();
		while(rs.next()) {
			Student std = new Student();
			std.setStdNo(rs.getNString("std_no"));
			std.setStdName(rs.getNString("std_name"));
			std.setStdPhone(rs.getString("std_phone"));
			std.setEngScore(rs.getInt("eng_score"));
			std.setMathScore(rs.getInt("math_score"));
			return std;
		}
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disConnect();
	}
		return null;
}
	
	
	// 점수등록
	// 등록 반환값boolean 매개Student 메소드updateStudent
	public boolean updateStudent(Student std) {
		getConn();
		String sql = "update tbl_student"
				+"    set eng_score = ?"
				+",        math_score = ?"
				+ "where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore());
			psmt.setInt(2, std.getMathScore());
			psmt.setString(3, std.getStdNo());
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 등록 반환값boolean 매개Student 메소드insertStudent
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no" + "                             ,std_name"
				+ "                             ,std_phone)" + "   values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getStdPhone());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return false;
	}

	// 학생목록
	public ArrayList<Student> studentList() {
		getConn();
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "select * from tbl_student";
		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환
			rs = psmt.executeQuery();
			// 반복 ArrayList에 담는 작업
			while (rs.next()) {
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setMathScore(rs.getInt("math_score"));

				studList.add(stud); // ArrayList에 추가
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 연결해제
		}

		return studList;
	}
}
