package edu.skku.java.school;

public class Staff extends Person{
	//���� ����
	private String dept;
	private String position;
	
	//������ ����
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
		System.out.println("<ID>\t<�̸�>\t<����>\t<����>\t<�ٹ��μ�>\t<����>");
		System.out.println(toString());
	}
	
	//doWork(String dept)
	public void doWork(String dept) {
		System.out.println(dept+"���� �ٹ��մϴ�.");
	}
	

}
