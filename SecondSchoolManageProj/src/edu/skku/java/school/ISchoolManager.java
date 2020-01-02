package edu.skku.java.school;

import java.util.ArrayList;

public interface ISchoolManager {
	
	//�������� ������ �߰��ϴ� �Լ�
	public boolean addMember(Person p);
	
	//�������� ������ ��ȸ�ϴ� �Լ�
	public Person selectMember(String id);
	
	//�������� ������ �ҷ����� �Լ�
	public ArrayList<Person> getAllMember();
	
	//�������� ������ �����ϴ� �Լ�
	public boolean modifyMember(String id,int age);
		
	//�������� ������ �����ϴ� �Լ�
	public boolean deleteMember(String id);
	
	

}
