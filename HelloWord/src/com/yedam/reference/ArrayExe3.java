package com.yedam.reference;

import java.util.Scanner;

//은행 프로그램 1.0
//작성자: 김태홍
//작성일시: 2024.11.29
//
//수정일            수정자        수정내용
//------------------------------------------------
//2024.11.29       홍길동       신규작업
public class ArrayExe3 {
	public static void main(String[] args) {
		// 배열 인덱스 활용 (같은 순번에 있는 값들은 동일한 사람의 값으로 인식)
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };
		for (int i = 0; i < names.length; i++)
			System.out.println(names[1] + "의 점수는" + scores[1]);

		// quit 입력하면 프로그램 종료.
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = ""; // 사용자 입력값 names[i].equals(searchName)

		while (run) {// names 배열에서 사용한 입력자 이름.//quit입력시 종료
			System.out.println("이름을 입력하세요");
			// 1.사용자 입력값을 searchName저장
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				break;
			}
			// 2. searchName의 값을 names배열에서 검색
			boolean isExists = false;
			int idx = 0;
			for (int i = 0; i < names.length; i++) {
				isExists = names[i].equals(searchName);
				if (isExists) {
					idx = i;
					break;
				}

			}//3찾는 이름 있으면 이름과 점수 출력
			 //4없으면 찾는이름 없음 출력
			 
			if (isExists) {
				System.out.println("찾는 이름이 있습니다" + " " + names[idx] + scores[idx]);
			} else {
				System.out.println("찾는 이름이 없습니다!!");
			}//end of if구문
			//5입력값이 quit면 while반복문 종료
			
		}//end of while.
		System.out.println("프로그램 종료");
	} //end of main
}
