package edu.skku.java.school;

public class Staff extends Person{
	//변수 설정
	private String dept;
	private String position;
	
	//생성자 생성
	public Staff(String id, String name, int age, String job, String dept, String position) {
		super(id, name, age, job);
		this.dept = dept;
		this.position = position;
	}
	
	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}
	
	//toString
	@Override
	public String toString() {
		return  super.toString()+"\t" + dept+"\t"+position;
	}
	
	//showMyInfo
	@Override
	public void showMyInfo() {
		System.out.println("<ID>\t<이름>\t<나이>\t<구분>\t<근무부서>\t<직급>");
		System.out.println(toString());
	}
	
	//doWork(String dept)
	public void doWork(String dept) {
		System.out.println(dept+"에서 근무합니다.");
	}
	

}
