package com.yedam.variable;

public class TodoExe1 {
	public static void main(String[] args) {
		//Math.random(): 0~1임의의 실수.
		//1~100 까지임의의 정수 3번 생성
		//3개의 변수의 합, 강제형변환((int)3.1)
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			int random = (int) (Math.random() * 100) + 1; // 
			
			sum +=  random;
			
		}
		System.out.println(sum);
	}
}
