package com.yedam.variable;

public class IntExe3 {
	public static void main(String[] args) {
		boolean b1 = true;
		b1 = 10 > 20;

		char c1 = 0;//unicode 코드값을 매핑.
		c1=65;
//		for(int i=1;i<=100;i++) {
//			
//		System.out.println(c1++);
//		}
		char c2 = '끂';//"Hello" 비교
		System.out.println((int)c2);
		
		int n1 = 1;
		int n2 = 2;
		double result4 = n1*1.0/n2; //자동형변환(promotion) 0.5 => 0
		System.out.println("n1/n2의 결과"+result4);
		//bytr(1바이트)< short(2바이트)<int(4바이트)<long(8바이트),float<double
	}
}
