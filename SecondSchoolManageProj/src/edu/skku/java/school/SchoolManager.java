package edu.skku.java.school;

import java.util.ArrayList;
import java.util.Iterator;

public class SchoolManager implements ISchoolManager {

	ArrayList<Person> member;
	
	public SchoolManager() {
		
		member  = new ArrayList<Person>();
	}
	//������ �߰�- �߰��� �ߺ��� id�� name ������ false�� �����ϰ�  ���� �ȵǰ� ������ �� 
	@Override
	public boolean addMember(Person p) {
		for(Person i : member) {
			if(p.getId().equals(i.getId())&& p.getName().equals(i.getName())) {
				System.out.println("������ ID�� �̸��� �̹� ��ϵǾ� �ֽ��ϴ�.");
				return false;
			}
		}
		member.add(p);
		return true;
	}

	//������ ��ȸ- ��ȸ�� �ش� ID ������ false�� �����ϰ� ����� ȭ�鿡 ǥ���� ��
	@Override
	public Person selectMember(String id) {
		for(Person i : member) {
			if(id.equals(i.getId())) {
				return i;
			}
		}
		System.out.println("�ش� ID�� �������� �ʽ��ϴ�.");
		return null;
	}

	// ������ ��ü ���� ���-??
	@Override
	public ArrayList<Person> getAllMember() {
		return member;
	}

	// ���� - ������ �ش� ID ������ false�� �����ϰ� ����� ȭ�鿡 ǥ���� ��
	@Override
	public boolean modifyMember(String id, int age) {
		for(Person i : member) {
			if(id.equals(i.getId())) {
				i.setAge(age);
				return true;
			}
		}
		System.out.println("�ش� ID�� �������� �ʽ��ϴ�.");
		return false;
	}

	// ���� - ������ �ش� ID ������ false�� �����ϰ� ����� ȭ�鿡 ǥ���� �� 
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
		System.out.println("�ش� ID�� �������� �ʽ��ϴ�.");
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
