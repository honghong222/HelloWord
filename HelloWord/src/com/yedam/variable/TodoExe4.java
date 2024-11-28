package com.yedam.variable;

import java.util.Scanner;

public class TodoExe4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("몇단까지 출력 하겠습니까>>");
		int dan = scn.nextInt(); // 사용자 입력값을 int 반환
		for (int j = 0; j <= 9; j++) {
			// System.out.printf("%d 단입니다. \n",j);
			for (int i = 2; i <= dan; i++) {

				System.out.printf("%d* %d =%2d  ", i, j, j * i);
			}
			System.out.println();
		}
		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= 5; i++) {
				if (i <= j) {
					System.out.printf("*");
				}
			}
			System.out.println();
		}
		for(int j=5; j<=1; j--) {
			for(int i =1; i<=j; i++);{
			
				System.out.printf("*");
				
				
			}
		}
		System.out.println("end of prog.");
	}

}
