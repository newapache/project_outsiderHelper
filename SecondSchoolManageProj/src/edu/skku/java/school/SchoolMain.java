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
			System.out.println(" -------------------------------- SKKU 회원 관리 프로그램 ---------------------------------- ");
			System.out.println("다음의 메뉴를 선택하세요(번호)\n1.회원가입,  2.회원정보 조회,  3.회원정보 수정,  4.전체 회원 정보조회,\n5.회원정보 삭제\n100.프로그램 종료");
			System.out.println(" ------------------------------------------------------------------------------------ ");
			
			Person p;
			
			act = sc.nextInt();
			if(act == 1) {
					
				System.out.println("구분을 선택하세요(번호)\n1.학생,  2.교수,  3.교직원");
				position = sc.nextInt();
				
				if(position == 1) {
					System.out.println("정보를 입력하세요.(ID / 이름 / 나이 / 구분(학생) / 전공학과 / 학년)");
					p = new Student(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.nextInt());
					p.showMyInfo();
					m1.addMember(p);
					Student s = (Student)p;
					s.study(s.getMajor());}
				else if(position == 2) {
					System.out.println("정보를 입력하세요.(ID / 이름 / 나이 / 구분(교수) / 담당학과)");
					p = new Teacher(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next());
					p.showMyInfo();
					m1.addMember(p);
					Teacher t = (Teacher)p;
					t.teach(t.getSubject());}
				else if(position == 3) {
					System.out.println("정보를 입력하세요.(ID / 이름 / 나이 / 구분(교직원) / 근무부서 / 직급)");
					p = new Staff(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.next());
					p.showMyInfo();
					m1.addMember(p);
					Staff st = (Staff)p;
					st.doWork(st.getDept());}
			}
			
			if(act == 2) {
				System.out.println("조회할 회원의 ID를 입력하세요.");
				id = sc.next();
				if(m1.selectMember(id) != null ) System.out.println(m1.selectMember(id));
			}
			
			if(act == 3) {
				System.out.println("회원의 ID와 수정할 나이를 입력하세요.");
				id = sc.next();
				age = sc.nextInt();
				m1.modifyMember(id, age);
			}
			if(act == 4) {
				System.out.println(m1.getAllMember());
			}
			
			if(act == 5) {
				System.out.println("삭제할 회원의 ID를 입력하세요.");
				id = sc.next();
				m1.deleteMember(id);
			}
			
			
				
			}
			}
			
	}
		
		

	



