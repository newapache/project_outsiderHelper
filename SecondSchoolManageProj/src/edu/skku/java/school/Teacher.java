package edu.skku.java.school;

public class Teacher extends Person{
	
	//변수설정
	private String subject;

	//생성자 생성
	public Teacher(String id, String name, int age, String job, String subject) {
		super(id, name, age, job);
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	//toString
	@Override
	public String toString() {
		return  super.toString()+"\t" + subject;
	}


	//showMyInfo
	@Override
	public void showMyInfo() {
		System.out.println("<ID>\t<이름>\t<나이>\t<구분>\t<담당학과>");
		System.out.println(toString()); 
	}
	
	
	//teach(String class)
	public void teach(String subject) {
		System.out.println(subject+" 교수입니다.");
	}
	
	
	

}
