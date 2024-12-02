package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001"); //'new + 클래스명'실체생성(인스턴스 생성)
		//s1.studentNumber = "S001";
		s1.studentName = "홍길동";
		s1.studentEnglish = 60;
		s1.studentMath = 70;
		System.out.println(s1.studentNumber+","+s1.studentName+"의 합계점수는" + s1.sumScore());
		
		
		
		Student s2 = new Student("s002","김길동");
		s1.studentEnglish = 70;
		s1.studentMath = 75;
		System.out.println(s2.studentNumber+","+s2.studentName+"의 합계점수는" + s1.sumScore());
		
		Student s3 = new Student("s003","최길동", 80, 90);
		System.out.println(s3.studentNumber+","+s3.studentName+",eng:"+s3.studentEnglish+",math:"+s3.studentMath);
		
		System.out.println(s1 == s2);
		int num = 100;
		//Teacher t1 = new Teacher();
	}
}
