package com.project.user;

import java.util.Scanner;
import com.project.centerinfo.CenterInfoView;
import com.project.course.CourseApplication;
import com.project.courseinfo.CourseInfo;

import com.project.busstop.BusStopMain;
import com.project.main.MainView;
import com.project.notice.NoticeMain;
import com.project.user.mypage.MyPageMain;

/**
 * 일반회원의 로그인 후 화면을 담당하는 클래스입니다.
 *
 */
public class UserMain {

	/**
	 * 일반회원의 로그인 후 화면 선택에 따라 다른 화면을 연결시키는 메소드입니다.
	 */
	public static void LoginGeneralMember() {
		Scanner scan = new Scanner(System.in);
		String input = "";

		userMainView();

		boolean loop = true;

		while (loop) {

			input = scan.nextLine();

			if (input.equals("1")) {
				loop = false;
			} else if (input.equals("2")) {
				CenterInfoView.centerInfo();
				userMainView();
			} else if (input.equals("3")) {
				CourseInfo.courseInfo();
				userMainView();
			} else if (input.equals("4")) {
				CourseApplication.courseApplicationMent();
				userMainView();
			} else if (input.equals("5")) {
				MyPageMain.mypage();
				loop = false;
			} else if (input.equals("6")) {
				BusStopMain.busStopMain();
				userMainView();
			} else if (input.equals("7")) {
				NoticeMain.noticeMainPage();
				userMainView();
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.print("재입력: ");
			}

		}

	}

	/**
	 * 일반회원의 로그인 후 화면 선택지를 출력하는 메소드입니다.
	 */
	public static void userMainView() {
		System.out.println("         일반회원 로그인 후 화면");
		System.out.println("------------------------");
		System.out.println("1. 로그아웃");
		System.out.println("2. 센터정보");
		System.out.println("3. 수강신청 안내 페이지");
		System.out.println("4. 수강신청");
		System.out.println("5. 마이페이지");
		System.out.println("6. 셔틀");
		System.out.println("7. 공지사항");
		System.out.println("------------------------");
		System.out.print("번호 입력 : ");
	}
}
