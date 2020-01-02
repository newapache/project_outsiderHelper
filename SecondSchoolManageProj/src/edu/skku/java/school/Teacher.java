package edu.skku.java.school;

public class Teacher extends Person{
	
	//��������
	private String subject;

	//������ ����
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
		System.out.println("<ID>\t<�̸�>\t<����>\t<����>\t<����а�>");
		System.out.println(toString()); 
	}
	
	
	//teach(String class)
	public void teach(String subject) {
		System.out.println(subject+" �����Դϴ�.");
	}
	
	
	

}
