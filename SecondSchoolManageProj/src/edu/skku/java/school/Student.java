package edu.skku.java.school;

public class Student extends Person{

	//��������
	private String major;
	private int grade;

	//������ ����
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
		System.out.println("<ID>\t<�̸�>\t<����>\t<����>\t<�����а�>\t<�г�>");
		System.out.println(toString()); 
	}
	
	//study(String major)
	public void study(String major) {
		System.out.println(major+" �л��Դϴ�.");
	}

	
}
