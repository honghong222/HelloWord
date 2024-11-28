package com.yedam.variable;

public class IntExe4 {
	public static void main(String[] args) {
		String msg = new String("Hello, Word"); //msg 주소값에 문자객체의 주소를 참조한다.
		int age = 10; //age 주소값에 10의 값이 담겨있다
		
		int myAge = age;
		myAge =20;
		
		
		System.out.println("age=>"+age+",myAge=>"+myAge);
		System.out.println(msg.equals ("Hello, Word"));
		System.out.println(msg == ("Hello, Word"));
		
	}
}
