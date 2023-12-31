package com.project.user.login;

import java.util.Scanner;

import com.project.authentication.Authentication;
import com.project.teacher.TeacherMain;
import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;

/**
 * 
 * 강사회원 로그인 클래스
 *
 */
public class LoginTeacher {

	/**
	 * 강사회원의 로그인을 위한 정보를 입력받는 메소드
	 * 
	 */
	public static DataTeacher login() {
		String id = "";
		String password = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("======================");
		System.out.println("    강사 회원 로그인      ");
		System.out.println("======================");
		System.out.println();

		int PwErrorCnt = 0;

		while (true) {
			System.out.print("아이디: ");
			id = scan.nextLine();
			System.out.println();
			System.out.print("비밀번호: ");
			password = scan.nextLine();
			// 아이디 틀린경우
			if (UserDbms.searchTeacherById(id) == null) {
				System.out.println("아이디 또는 비밀번호가 틀립니다.");
			} else if (UserDbms.searchTeacherByIdPw(id, password) == null) {
				System.out.println("비밀번호가 틀립니다.");
				PwErrorCnt++;
				System.out.println();
			} else {
				break;
			}
			if (PwErrorCnt >= 5) {
				FindData.resetPw();
				break;
			}
		}

		if (!(PwErrorCnt >= 5)) {
			System.out.println();
			System.out.println("======================");
			System.out.println();

			//세 줄 추가
			DataTeacher curTeacher = UserDbms.searchTeacherByIdPw(id, password);
			Authentication.loginUserCode = curTeacher.getTeacherCode();
			System.out.println(Authentication.loginUserCode);

			System.out.println("로그인이 완료되었습니다.");

			// TODO 로그인 후 화면으로 이동해야함
			TeacherMain.LoginTeacher(null); //null 추가

			return UserDbms.searchTeacherByIdPw(id, password);
		} else {
			System.out.println();
			System.out.println("======================");
			System.out.println();

			System.out.println("비밀번호 입력 횟수를 초과했습니다.");
			System.out.println("비밀번호를 재설정 해주세요.");

			return null;
		}

	}

}
