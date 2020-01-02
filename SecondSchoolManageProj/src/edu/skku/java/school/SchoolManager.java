package edu.skku.java.school;

import java.util.ArrayList;
import java.util.Iterator;

public class SchoolManager implements ISchoolManager {

	ArrayList<Person> member;
	
	public SchoolManager() {
		
		member  = new ArrayList<Person>();
	}
	//구성원 추가- 추가시 중복된 id와 name 있으면 false를 리턴하고  저장 안되게 구현핛 것 
	@Override
	public boolean addMember(Person p) {
		for(Person i : member) {
			if(p.getId().equals(i.getId())&& p.getName().equals(i.getName())) {
				System.out.println("동일한 ID와 이름이 이미 등록되어 있습니다.");
				return false;
			}
		}
		member.add(p);
		return true;
	}

	//구성원 조회- 조회시 해당 ID 없으면 false를 리턴하고 결과를 화면에 표출할 것
	@Override
	public Person selectMember(String id) {
		for(Person i : member) {
			if(id.equals(i.getId())) {
				return i;
			}
		}
		System.out.println("해당 ID가 존재하지 않습니다.");
		return null;
	}

	// 구성원 전체 정보 출력-??
	@Override
	public ArrayList<Person> getAllMember() {
		return member;
	}

	// 수정 - 수정시 해당 ID 없으면 false를 리턴하고 결과를 화면에 표출핛 것
	@Override
	public boolean modifyMember(String id, int age) {
		for(Person i : member) {
			if(id.equals(i.getId())) {
				i.setAge(age);
				return true;
			}
		}
		System.out.println("해당 ID가 존재하지 않습니다.");
		return false;
	}

	// 삭제 - 삭제시 해당 ID 없으면 false를 리턴하고 결과를 화면에 표출핛 것 
	@Override
	public boolean deleteMember(String id) {
		Iterator<Person> iter = member.iterator();
		while (iter.hasNext()) {
			Person i = iter.next();
		 
			if (i.getId().equals(id)) {
				iter.remove();
			}
			return true;
		}
		System.out.println("해당 ID가 존재하지 않습니다.");
		return false;
	}
		/*for(Person i : member) {
			if(id.equals(i.getId())) {
				member.remove(i);
				}
				return true;
			}
		*/


}
