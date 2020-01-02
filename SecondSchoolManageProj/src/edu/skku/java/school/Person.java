package edu.skku.java.school;

public class Person {
	
	//���� ����
	private String id;
	private String name;
	private int age;
	private String job;
	
	//������ ����
	public Person(String id, String name, int age, String job) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	//getter&setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
	//equals �Լ� �������̵�
	@Override
	public boolean equals(Object obj) {
		if(obj!=null&& obj instanceof Person){
			Person p = (Person) obj;
			if(this.name.equals(p.getName()) && id.equals(p.getId())){
				return true;
		}
		}
		return false;
	}
	
	
	//toString 
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + age + "\t" + job;
	}

	
	//showMyInfo
	public void showMyInfo() {
		System.out.println("<ID>\t<�̸�>\t<����>\t<����>\t<�ٹ��μ�>\t<����>");
		System.out.println(this.toString());
	}
	

}
