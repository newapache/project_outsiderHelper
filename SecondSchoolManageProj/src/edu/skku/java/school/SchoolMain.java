package edu.skku.java.school;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int act = 0;
		int position = 0;
		String id = "";
		int age = 0;
		
		
		SchoolManager m1 = new SchoolManager();
		
		while(act != 100) {
			System.out.println(" -------------------------------- SKKU ȸ�� ���� ���α׷� ---------------------------------- ");
			System.out.println("������ �޴��� �����ϼ���(��ȣ)\n1.ȸ������,  2.ȸ������ ��ȸ,  3.ȸ������ ����,  4.��ü ȸ�� ������ȸ,\n5.ȸ������ ����\n100.���α׷� ����");
			System.out.println(" ------------------------------------------------------------------------------------ ");
			
			Person p;
			
			act = sc.nextInt();
			if(act == 1) {
					
				System.out.println("������ �����ϼ���(��ȣ)\n1.�л�,  2.����,  3.������");
				position = sc.nextInt();
				
				if(position == 1) {
					System.out.println("������ �Է��ϼ���.(ID / �̸� / ���� / ����(�л�) / �����а� / �г�)");
					p = new Student(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.nextInt());
					p.showMyInfo();
					m1.addMember(p);
					Student s = (Student)p;
					s.study(s.getMajor());}
				else if(position == 2) {
					System.out.println("������ �Է��ϼ���.(ID / �̸� / ���� / ����(����) / ����а�)");
					p = new Teacher(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next());
					p.showMyInfo();
					m1.addMember(p);
					Teacher t = (Teacher)p;
					t.teach(t.getSubject());}
				else if(position == 3) {
					System.out.println("������ �Է��ϼ���.(ID / �̸� / ���� / ����(������) / �ٹ��μ� / ����)");
					p = new Staff(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.next());
					p.showMyInfo();
					m1.addMember(p);
					Staff st = (Staff)p;
					st.doWork(st.getDept());}
			}
			
			if(act == 2) {
				System.out.println("��ȸ�� ȸ���� ID�� �Է��ϼ���.");
				id = sc.next();
				if(m1.selectMember(id) != null ) System.out.println(m1.selectMember(id));
			}
			
			if(act == 3) {
				System.out.println("ȸ���� ID�� ������ ���̸� �Է��ϼ���.");
				id = sc.next();
				age = sc.nextInt();
				m1.modifyMember(id, age);
			}
			if(act == 4) {
				System.out.println(m1.getAllMember());
			}
			
			if(act == 5) {
				System.out.println("������ ȸ���� ID�� �Է��ϼ���.");
				id = sc.next();
				m1.deleteMember(id);
			}
			
			
				
			}
			}
			
	}
		
		

	



