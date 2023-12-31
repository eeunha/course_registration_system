package com.project.teacher;

import com.project.user.login.LoginMain;
import com.project.user.login.LoginTeacher;
import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;
import com.project.auth.Auth;
import com.project.authentication.Authentication;
import com.project.main.MainView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 강사 마이페이지의 기능을 담당하는 클래스입니다.
 *
 */
public class Teacher {

	/**
	 * 강사 마이페이지를 출력하고 선택지에 따라 출력하는 화면을 연결시켜주는 메소드입니다.
	 */

	public static void mypage() {

		Scanner scan = new Scanner(System.in);

		int input = 0;
		String input2 = "";

		System.out.println("         강사 마이페이지");
		System.out.println("—----------------------------");
		System.out.println("0. 메인화면 돌아가기");
		System.out.println("1. 내 정보 조회/수정");
		System.out.println("2. 회원 탈퇴");
		System.out.println("—----------------------------");
		System.out.print("번호 입력 : ");

		input = scan.nextInt();
		scan.nextLine();

		if (input == 0) {

			TeacherMain.LoginTeacher(null);

		} else if (input == 1) {

			Teacher.checkInformation();

		} else if (input == 2) {
			
			System.out.println("정말로 회원 탈퇴하시겠습니까? (Y/N)");
			System.out.println("Y 또는 N 입력: ");
			input2 =scan.nextLine();
			
			if(input2.equals("Y")) {
				
				Authentication.loginUserCode = null;
				
				System.out.println("회원 탈퇴되었습니다.");
				
			} else {
				
				TeacherMain.LoginTeacher(null);
				
			}
			
			MainView.MainScreen();

		} else {

			System.out.println("잘못된 입력입니다.");
		}
	}

	/**
	 * 강사 마이페이지 기능 중 내 정보 조회를 담당하는 메소드 입니다.
	 */
	public static void checkInformation() {

		//String id = "aldfjsk0425";
		String code = Authentication.loginUserCode;
		 
		Scanner scan = new Scanner(System.in);

		UserDbms list = new UserDbms();
		ArrayList<DataTeacher> allTeacherList = UserDbms.getTeacherAllList();

		//강사 로그인 데이터 가져오기
//		LoginMain lista = new LoginMain();
//		ArrayList<DataTeacher> loginList = lista.getLoginTList();
//		System.out.println(lista.getLoginTList());

//		System.out.println(loginList.get(0).getId());
		// 향상된 for 문은 writer 과정에서 오류가 날 수 있으므로 오류 발생 시 for문으로 수정해야함

//		LoginMain lista = new LoginMain();
//		lista.getLoginTList().get(0);

		for (DataTeacher data : allTeacherList) {

			if (data.getTeacherCode().equals(code)) {
				int input = 0;
				String name = "";
				String phone = "";
				
				System.out.println("            내 정보 조회 및 수정");
				System.out.println("—-------------------------------------");
				System.out.println("아이디: " + data.getId());
				System.out.println("이름: " + data.getName());
				System.out.println("전화번호: " + data.getTel());
				System.out.println("강사코드: " + data.getTeacherCode());
				System.out.println("0. 마이페이지 돌아가기");
				System.out.println();
				System.out.println("수정가능한 항목");
				System.out.println("1. 이름");
				System.out.println("2. 전화번호");
				System.out.println("—-------------------------------------");
				System.out.print("번호 입력 : ");

				input = scan.nextInt();
				scan.nextLine();

				if (input == 0) {

					Teacher.mypage();

				} else if (input == 1) {

					System.out.print("수정할 이름을 입력하세요: ");

					name = scan.nextLine();

					modifyByName(code, name);

				} else if (input == 2) {

					System.out.print("수정할 전화번호를 입력하세요: ");

					phone = scan.nextLine();

					modifyByPhone(code, phone);

				} else {

					System.out.println("잘못된 입력입니다.");

				}

			}

		}

	}

	private static void modifyByName(String code, String name) {

		try {
			// 강사 파일 읽어오기
			String path = "data/dataTeacher.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {
				// 현재 줄을 split
				String[] temp = line.split(",");

				String curCode = temp[0];
				String curId = temp[1];
				String curPw = temp[2];
				String curName = temp[3];
				String curTel = temp[4];
				String curBirth = temp[5];
				String curWithdrawal = temp[6];

				// 현재 줄의 강사 코드와 현재 강사 코드가 같은지 비교
				if (curCode.equals(code)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					curName = name;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(curCode + "," + curId + "," + curPw + "," + curName + "," + curTel + "," + curBirth + ","
						+ curWithdrawal + "\r\n");

			}

			// 파일 작성

			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString());
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

	private static void modifyByPhone(String code, String phone) {

		// 실제 데이터 파일을 수정하여 파일을 작성하고, 다시 리스트를 만들자

		try {
			// 강사 파일 읽어오기
			String path = "data/dataTeacher.txt";

			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;

			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {
				// 현재 줄을 split
				String[] temp = line.split(",");

				String curCode = temp[0];
				String curId = temp[1];
				String curPw = temp[2];
				String curName = temp[3];
				String curTel = temp[4];
				String curBirth = temp[5];
				String curWithdrawal = temp[6];

				// 현재 줄의 강사 코드와 현재 강사 코드가 같은지 비교
				if (curCode.equals(code)) {
					// 같으면 현재 줄의 이름을 입력받은 이름으로 변경
					curTel = phone;
				}

				// 다르다면 그 줄 그대로 파일에 작성
				sb.append(curCode + "," + curId + "," + curPw + "," + curName + "," + curTel + "," + curBirth + ","
						+ curWithdrawal + "\r\n");

			}

			// 파일 작성

			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sb.toString());
			writer.close();

		} catch (Exception e) {
			System.out.println("at Teacher.modifyByName");
			e.printStackTrace();
		}

	}

//	public void modifyInformation() {
//
//		Scanner scan = new Scanner(System.in);
//
//		int input = 0;
//		String name = "";
//		String phone = "";
//
//		System.out.println("       강사 마이페이지 > 내 정보 수정");
//		System.out.println("—-------------------------------------");
//		System.out.println("0. 마이페이지 돌아가기");
//		System.out.println("1. 이름");
//		System.out.println("2. 전화번호");
//		System.out.println("—-------------------------------------");
//		System.out.print("번호 입력 : ");
//
//		input = scan.nextInt();
//
//		if (input == 0) {	
//			
//			Teacher mypage = new Teacher();
//			mypage.mypage();
//			
//		} else if (input == 1) {
//			
//			System.out.print("수정할 이름을 입력하세요: ");
//			name = scan.nextLine();
//			
//		} else if (input == 2) {
//			
//			System.out.print("수정할 전화번호를 입력하세요: ");
//			phone = scan.nextLine();
//			
//		} else {
//			
//			System.out.println("잘못된 입력입니다.");
//		}
//		
//		
//		
//		
//	}

}// class
