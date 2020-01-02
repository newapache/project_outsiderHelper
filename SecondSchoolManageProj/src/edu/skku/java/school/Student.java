package edu.skku.java.school;

public class Student extends Person{

	//변수설정
	private String major;
	private int grade;

	//생성자 생성
	public Student(String id, String name, int age, String job, String major, int grade) {
		super(id, name, age, job);
		this.major = major;
		this.grade = grade;
	}
	
	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	//toString
	@Override
	public String toString() {
		return  super.toString()+"\t" + major+"\t"+grade;
	}
	
	//showMyInfo
	@Override
	public void showMyInfo() {
		System.out.println("<ID>\t<이름>\t<나이>\t<구분>\t<전공학과>\t<학년>");
		System.out.println(toString()); 
	}
	
	//study(String major)
	public void study(String major) {
		System.out.println(major+" 학생입니다.");
	}

	
}
