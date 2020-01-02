package edu.skku.java.school;

public class Person {
	
	//변수 설정
	private String id;
	private String name;
	private int age;
	private String job;
	
	//생성자 생성
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
	
	
	//equals 함수 오버라이딩
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
		System.out.println("<ID>\t<이름>\t<나이>\t<구분>\t<근무부서>\t<직급>");
		System.out.println(this.toString());
	}
	

}
