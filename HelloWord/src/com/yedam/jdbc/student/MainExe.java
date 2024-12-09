package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {

	static Scanner scn = new Scanner(System.in);
	// db 처리기능.
	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) {
		boolean run = true;

		// 로그인 기능.

		while (run) {
			System.out.println("회원 아이디 >> ");
			String id = scn.nextLine();
			System.out.println("회원 비밀번호 >> ");
			String pw = scn.nextLine();
			if (dao.login(id, pw)) {
				System.out.println("로그인 됐습니다.");
				break;
			} else if (dao.login(id, pw) == false) {
				System.out.println("아이디와 비밀번호를 확인해주세요");
			}
		} // end of while.

		while (run) {
			System.out.println("1.목록 2.등록 3.점수등록 4.상세조회 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 목록.
				list();
				break;
			case 2: // 등록.
				System.out.println("학생 번호 입력 >>");
				String no = scn.nextLine();
				System.out.println("학생 이름 입력 >>");
				String name = scn.nextLine();
				System.out.println("연락처 입력 >>");
				String phone = scn.nextLine();

				Student std = new Student(no, name, phone);
//				Student std = new Student();
//				std.setStdNo(no);
//				std.setStdName(name);
//				std.setStdPhone(phone);

				if (dao.insertStudent(std)) {
					System.out.println("정상 등록.");
				} else {
					System.out.println("등록 실패.");
				}
				break;
			case 3: // 점수등록.
				System.out.println("학생번호 입력>> ");
				no = scn.nextLine();
				System.out.println("영어점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());

				std = new Student();
				std.setEngScore(escore);
				std.setMathScore(mscore);
				std.setStdNo(no);

				if (dao.updateStudent(std)) {
					System.out.println("수정 성공.");
				} else {
					System.out.println("수정 실패.");
				}
				break;
			case 4: // 상세조회
				System.out.println("학생번호 입력>> ");
				no = scn.nextLine();

				std = dao.selectStudent(no); // Student 값 반환.
				if (std == null) {
					System.out.println("조회된 결과가 없습니다.");
					break;
				} else {
					System.out.println(std.showInfo());
				}
				break;
			case 9: // 종료.
				run = false;
			}
		}
		System.out.println("end of prog.");
	}// end of main.

	// 목록기능.
	public static void list() {
		Search search = new Search();

		System.out.println("1.학생이름 2.연락처 3.영어");
		System.out.println("선택 >> ");

		int menu = Integer.parseInt(scn.nextLine());

		switch (menu) {
		case 1: // 학생이름.
			System.out.println("검색 할 이름 >> ");
			String name = scn.nextLine();
			search.setName(name);
			break;

		case 2: // 연락처.
			System.out.println("검색 할 연락처 >>");
			String phone = scn.nextLine();
			search.setPhone(phone);
			break;

		case 3: // 영어.
			System.out.println("검색 할 영어점수 >>");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);
			break;

		} // end of switch.
			// 정렬 조건 추가. orderBy => 값을 ? 지정.
		System.out.println("1.학생번호정렬 2.학생이름정렬");
		System.out.println("선택 >> ");
		int orderBy = Integer.parseInt(scn.nextLine());

		switch (orderBy) {
		case 1: // 학생번호정렬.
			search.setOrderBy("std_no");
			break;
		case 2: // 학생이름정렬.
			search.setOrderBy("std_name");
			break;
		}

		ArrayList<Student> list = dao.studentList(search);
		for (Student stud : list) { // 학생번호, 이름, 연락처
			System.out.println(stud.showInfo());
		}
	} // end of list().
} // end of class.
