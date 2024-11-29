package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동"); // "홍길동"
		int age = 20;
		
		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "1999-04-05";
		
		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "1999-08-08";
		
		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "1999-09-09";
		
		Friend[] myFriend = {f1,f2,f3};
// System.out.println(myFriends[0].friendName)		
// System.out.println(myFriends[0].friendPhone)		
// System.out.println(myFriends[0].friendBirth)		
		
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = "";
		
		while(run) {
			//1 사용자 입력값을 searchName에 저장
			System.out.print("이름입력");
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				break;
			}
			
			boolean isExists = false;
			int idx = -1;
					for(int i = 0; i<myFriend.length; i++) {
						isExists = myFriend[i].friendName.equals(searchName);
						if(isExists) {
							idx=i;
							break;
						}
					}
					if (isExists) {
						System.out.println(myFriend[idx].friendName+", "
					+myFriend[idx].friendPhone+", "+myFriend[idx].friendBirth);
					} else {
						System.out.println("없습니다");
					}
		}
		
		
	}
}
