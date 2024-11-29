package com.yedam.variable;

public class TodoExe5 {
	public static void main(String[] args) {
		//1에서 100까지의 정수 중 3배수의 합을 구하고 출력
		//for (int i = 3; i < 3; i++) {}
		
		//    *
		//   **
		//  ***
		// ****
		//*****
	for(int i =0; i<5; i++) {
		for(int j=4; j>i; j--) {
			System.out.print(" ");
		}
		for(int p=0; p<i+1; p++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	for(int i = 5;i>=1;i--){
		for (int j = 1; j <= 5; j++) {
			if (j >= i) {
				System.out.print("*");
			} else {
				System.out.print(" ");
			}
			
		}System.out.println()
	}
}}
