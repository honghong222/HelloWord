package com.yedam.reference;

import java.util.Scanner;

/*
 * 친구정보 저장 기능
 * 1.친구정보 추가 2. 목록 3.조회(숙제) 4.수정(연락처) 9.종료
 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10];
//		storage[0] = new Friend();//꼭 이렇게 사용 중요
//		storage[0].friendName = "홍길동";
//		storage[0].friendPhone = "010-1111-1111";
//		storage[0].friendBirth = "1999-01-01";
		while (run) {
			System.out.println("1.친구정보 추가 2. 목록 3.조회(숙제) 4수정(연락처) 9.종료");
			System.out.print("선택>>");
			//1.친구정보 추가
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.print("친구 이름 입력>>");
				String name = scn.nextLine();
				System.out.print("친구 연락처 입력>>");
				String phone = scn.nextLine();
				System.out.print("친구 생일 입력>>");
				String birth = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
					// System.out.println(storage[i]);
					if (storage[i] == null) {// 비어있는 위치에 저장
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						break;// for 종료
					}
				}
				break;// switch 종료
			case 2://2. 목록
				System.out.println("");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %14s %10s \n", storage[i].friendName, storage[i].friendPhone,
								storage[i].friendBirth);
					}
				}
				break; // switch 종료
			case 3://3.조회(숙제)
				
			case 4://4.수정(연락처)
				
			case 9:
				run = false;
				break; // switch 종료
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}// end of switch

		} // end of while
		System.out.println("프로그램 끝");

	}// end of main()
}// end of class
