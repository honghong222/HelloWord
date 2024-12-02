package com.yedam.student;

import java.util.Scanner;

import com.yedam.reference.Friend;

//crud처리
//1. 추가 2. 목록 3. 수정(영어,수학 학생번호를 넣었을떄 수정 가능) 4.삭제 4.삭제 5.상세조회 9.종료
public class StudentManager {
	public static void main(String[] args) {
//		int[] intAry = {50,67,94,83,45};
//		for(int j=0; j<intAry.length -1; j++) {
//			//순번 변경, 배열크기 -1한 만큼 반복
//		for(int i = 0; i<intAry.length -1; i++) {
//			if(intAry[i] > intAry[i+1]) {
//				//i위치 - >  i+1위치, i+1위치 -> i위치
//				int temp = intAry[i];
//				intAry[i] = intAry[i+1];
//				intAry[i+1] = temp;
//			}
//		}
//		}
//		for (int num:intAry)
//		System.out.println(num);
//		Student[] storage = {new Student(), new Student()};
//		if(storage[0].studentEnglish + storage[0].studentMath > 
//		storage[1].studentEnglish + storage[0].studentMath) {
//		Student temp = storage[0];
//		storage[0] = storage[1];
//		storage[1] = temp;
//		}
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Student[] storage = new Student[10];

		while (run) {
			System.out.println("1.추가 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.print("선택=");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.print("학생 번호 입력>>");
				String number = scn.nextLine();
				System.out.print("학생 이름 입력>>");
				String name = scn.nextLine();
				System.out.print("학생 영어 성적 입력>>");
				String english = scn.nextLine();
				System.out.print("학생 수학 성적 입력>>");
				String math = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) {
						storage[i] = new Student(); //인스턴스 생성
						storage[i].studentNumber = number;
						storage[i].studentName = name;
						storage[i].studentEnglish = english;
						storage[i].studentMath = math;
						break;
					}
				}
				break;
			case 2:
				System.out.println(" ");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%3s %5s %4s %4s", storage[i].studentNumber, storage[i].studentName,
								storage[i].studentEnglish, storage[i].studentMath);
					}
				}
				break;
			case 3:
				System.out.print("학생 번호 입력");
				number = scn.nextLine();
				System.out.print("학생 영어 성적 입력");
				english = scn.nextLine();
				System.out.print("학생 수학 성적 입력");
				math = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentNumber.equals(number)) {
							storage[i].studentEnglish = english;
							storage[i].studentMath = math;
							break;
						}
					} else if (storage[i] == null) {
						System.out.println("학생 번호가 없습니다");
					}
				}
			case 4:
				System.out.print("학생번호 입력");
				number = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].studentNumber.equals(number)) {
							storage[i] = null;
							break;
						}
					}
				}
			case 5:
				 System.out.print("영어 점수 입력");
				 english = scn.nextLine();
				 System.out.print("수학 점수 입력");
				 math = scn.nextLine();
				 int sum = english + math;
					int avg = sum / 2;
					System.out.println("합계:"+sum+"	평균:"+avg);

			case 6:
				int[] intAry = {}
				for (int j = 0; j < intAry.length - 1; j++) {

					for (int i = 0; i < intAry.length - 1; i++) {
						Student[] storage = { new Student(), new Student() };
						if (storage[0].studentEnglish + storage[0].studentMath > storage[1].studentEnglish
								+ storage[1].studentMath) {
							Student temp = storage[0];
							storage[0] = storage[1];
							storage[1] = temp;
						}
					}
				}
			case 9:
				run = false;
				break;
			default:
				System.out.println("학생번호 다시 선택");
			}
			System.out.println("종료");
		}
	}
}
