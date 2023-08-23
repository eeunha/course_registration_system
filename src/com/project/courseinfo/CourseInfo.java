package com.project.courseinfo;

import java.util.Scanner;

public class CourseInfo {
	
	//수강 안내 페이지 출력 멘트
	public static void courseInfo() {
		
		
		
		Scanner scan = new Scanner(System.in);
		
		courseInfoList();
				
		boolean loop = true;
		
		while (loop) {
			
			String input = scan.nextLine();

			if (input.equals("0")) {
				loop = false;
			} else if (input.equals("1")) {
				Popularity.popularity();
				courseInfoList();
			} else if (input.equals("2")) {
				Individual.individual();
				courseInfoList();
			} else if (input.equals("3")) {
				CourseList.lectureListMent();
				courseInfoList();
			} else if (input.equals("4")) {
				Discount.discount();
				courseInfoList();
			} else if (input.equals("5")) {
				Refund.refund();
				courseInfoList();
			} else {
				System.out.println("목록에 있는 번호를 입력하세요.");
				System.out.print("입력: ");
			}
		}
		
		
	}


	public static void courseInfoList() {
	
		System.out.println();
		System.out.println("========================");
		System.out.println("수강신청 안내 페이지");
		System.out.println("========================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 이달의 추천");
		System.out.println("2. 개인별 강좌 추천");
		System.out.println("3. 강좌 목록 조회");
		System.out.println("4. 할인 대상 안내");
		System.out.println("5. 환불 안내");
		System.out.println("------------------------");
		System.out.print("입력: ");
		
	}
		
	
}
