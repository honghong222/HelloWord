package com.yedam.student;
//학생 성적 관리
//학생번호 학생이름 영어점수 수학점수
//
public class Student {
	public String studentNumber; //필드
	public String studentName;
	public int studentEnglish;
	public int studentMath;
	
	//컴파일러가 기본 생성자를 만들어준다.
	public Student() {}
	
	public Student(String studentNumber) {
		this.studentNumber = studentNumber; //'this 자기 자신이가지고있는 값을 담아준다'
	}
	
	public Student(String studentNumber,String studentName) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
	}
	
	public Student(String studentNumber,String studentName,int studentEnglish,int studentMath) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentEnglish = studentEnglish;
		this.studentMath = studentMath;
	}
	//메소드
	public void smile() {
		System.out.println("학생이 웃습니다");
	}
	public void introduce() {
		System.out.println("이름은"+studentName+"이고 학번은"+studentNumber);
	}
	
	public int sumScore() {
		return studentEnglish + studentMath;
	}
	
	//평균을 반환하는 메소드 : average(){}
	public int average() {
		numScore = studentEnglish + studentMath / 2;
	}
}
