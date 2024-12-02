package com.yedam.methods;
//학생 성적 관리
//학생번호 학생이름 영어점수 수학점수
//
public class Student {
	private String studentNumber; //필드
	private String studentName;
	private int studentEnglish;
	private int studentMath;
	
	//생성자 => 인스턴스를 생성해주면서 필드의 값을 초기화
	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public Student(String studentNumber, String studentName, int studentEnglish, int studentMath) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentEnglish = studentEnglish;
		this.studentMath = studentMath;
	}
	
	//getter, setter,메소드

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentEnglish() {
		return studentEnglish;
	}

	public void setStudentEnglish(int studentEnglish) {
		this.studentEnglish = studentEnglish;
	}

	public int getStudentMath() {
		return studentMath;
	}

	public void setStudentMath(int studentMath) {
		this.studentMath = studentMath;
	}
	//showInfo()
	public String showInfo() {
		return "학번:" + studentNumber + ",이름"+studentName + "영어점수:"+studentEnglish+"수학점수:"+studentMath)
	}
}