package com.project.courseinfo;

import java.util.Scanner;

public class Discount {
	static Scanner scan = new Scanner(System.in);
	

	public static void discount() {
		
		System.out.println();
		System.out.println("============================");
		System.out.println("할인 대상 안내");
		System.out.println("============================");
		System.out.println("[감면 대상이 아닌 회원]");
		System.out.println();
		System.out.println("기존 수강료 100% 결제");
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("[감면 대상 회원]");
		System.out.println();
		System.out.println("회원가입 시 받은 자료로 구분");
		System.out.println("국가유공자(본인) - 50%");
		System.out.println("장애인 - 50%");
		System.out.println("국민기초생활보장수급자 - 30%");
		System.out.println("다자녀부모와 자녀(세자녀 이상의 다둥이 카드 소지자) - 20%");
		System.out.println("만 65세 이상 - 20%");
		
		System.out.println();
		System.out.println("0.뒤로가기");
		System.out.print(">  ");
		
		int input = scan.nextInt();
		if (input == 0) {
			CourseInfo.lectureInfo();
		}

		
		
	}
}
