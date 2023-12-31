package com.project.user.login;

import java.util.Scanner;

import com.project.authentication.Authentication;
import com.project.user.data.DataAdmin;
import com.project.user.data.UserDbms;

/**
 * 
 * 관리자 회원 로그인 클래스
 *
 */
public class LoginAdmin {
	
	/**
	 * 
	 * 관리자 회원의 로그인을 위한 정보를 입력받는 메소드
	 */
	public static DataAdmin login() {
		String id = "";
		String password = "";

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("    관리자 회원 로그인      ");
		System.out.println("======================");
		System.out.println();

		int PwErrorCnt = 0;
		while (true) {
			System.out.print("아이디: ");
			id = scan.nextLine();
			System.out.println();
			System.out.print("비밀번호: ");
			password = scan.nextLine();
			// 아이디가 틀린경우
			if (UserDbms.searchAdminById(id) == null) {
				System.out.println("아이디 또는 비밀번호가 틀립니다.");
			} else if (UserDbms.searchAdminByIdPw(id, password) == null) {
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

			// 세 줄 추가
			DataAdmin curAdmin = UserDbms.searchAdminByIdPw(id, password);
			Authentication.loginUserCode = curAdmin.getAdminCode();
			System.out.println(Authentication.loginUserCode);

			System.out.println("로그인이 완료되었습니다.");
			// TODO 로그인 후 화면으로 이동해야함
			return UserDbms.searchAdminByIdPw(id, password);
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
