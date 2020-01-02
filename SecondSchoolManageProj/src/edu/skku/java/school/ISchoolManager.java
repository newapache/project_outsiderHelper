package edu.skku.java.school;

import java.util.ArrayList;

public interface ISchoolManager {
	
	//구성원의 정보를 추가하는 함수
	public boolean addMember(Person p);
	
	//구성원의 정보를 조회하는 함수
	public Person selectMember(String id);
	
	//구성원의 정보를 불러오는 함수
	public ArrayList<Person> getAllMember();
	
	//구성원의 정보를 수정하는 함수
	public boolean modifyMember(String id,int age);
		
	//구성원의 정보를 삭제하는 함수
	public boolean deleteMember(String id);
	
	

}
