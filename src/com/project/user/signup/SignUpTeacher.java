package com.project.user.signup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.user.data.DataTeacher;
import com.project.user.data.UserDbms;

public class SignUpTeacher {

	public static void addTeacher() {

		String teacherCode = "";
		String id = "";
		String password = "";
		String checkPassword = "";
		String name = "";
		String tel = "";
		String birth = "";
		DataTeacher t = new DataTeacher();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("======================");
		System.out.println("    강사 회원 가입    ");
		System.out.println("======================");
		System.out.println();
		
		System.out.print("아이디: ");
		id = scan.nextLine();
		
		while (!idCheck(id)) {
			System.out.println("유효하지 않은 아이디입니다. 다시 입력해주세요.");
			System.out.print("아이디: ");
			id = scan.nextLine();
		}
		
		while (!isIdTaken(id)) {
			System.out.println("이미 사용 중인 아이디입니다. 다시 입력해주세요.");
			System.out.print("아이디: ");
			id = scan.nextLine();
		}
		t.setId(id);
    
		System.out.println();
		System.out.print("비밀번호: ");
		password = scan.nextLine();
		
		while (!passwordCheck(password)) {
			System.out.println("유효하지 않은 비밀번호입니다. 다시 입력해주세요.");
			System.out.print("비밀번호: ");
			password = scan.nextLine();
		}
		
		System.out.println();	//비밀번호 입력하면 무조건 일치하지 않다고 뜸
		System.out.print("비밀번호 확인: ");
		checkPassword = scan.nextLine();
		if(!checkPassword.equals(password)) {
			System.out.println("입력하신 비밀번호와 일치하지 않습니다. 다시 입력해주세요.");
			System.out.print("비밀번호 확인: ");
			password = scan.nextLine();
		}else {
			
		}
		t.setPassword(password);
		
		System.out.println();
		System.out.print("이름: ");
		name = scan.nextLine();
		while (!nameCheck(name)) {
			System.out.println("유효하지 않은 이름입니다. 다시 입력해주세요.");
			System.out.print("이름: ");
			name = scan.nextLine();
		}
		t.setName(name);
		
		System.out.println();
		System.out.print("전화번호: ");
		tel = scan.nextLine();
		while (!telCheck(tel)) {
			System.out.println("유효하지 않은 전화번호입니다. 다시 입력해주세요.");
			System.out.print("전화번호: ");
			tel = scan.nextLine();
		}
		t.setTel(tel);
		
		System.out.println();
		System.out.print("생년월일: ");
		birth = scan.nextLine();		
		while (!birthCheck(birth)) {
			System.out.println("유효하지 않은 생년월일입니다. 다시 입력해주세요.");
			System.out.print("생년월일: ");
			birth = scan.nextLine();
		}
		t.setBirth(birth);

		
		t.setUsing(0);
		
		
		System.out.println();
		System.out.println("======================");
		System.out.println("회원가입이 완료되었습니다.");
		
		UserDbms.setTeacher(t);
		
		//TODO 메인으로 돌아가야 할 위치
		
	}//addTeacer

	


	//생일 유효성 검사
	 public static boolean birthCheck(String birth) {
        if (birth.length() != 8) {
            return false; 
        }

        try {
            int year = Integer.parseInt(birth.substring(0, 4));
            int month = Integer.parseInt(birth.substring(4, 6));
            int day = Integer.parseInt(birth.substring(6, 8));

            
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (year < 1903 || year > currentYear) {
                return false;
            }

           
            if (month < 1 || month > 12 || day < 1 || day > 31) {
                return false;
            }

            
            if ((month == 2 && day > 29) ||
                ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) ||
                (month == 2 && day == 29 && !isLeapYear(year))) {
                return false;
            }

         
            Date date = Calendar.getInstance().getTime();
            int currentDate = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(date));
            if (Integer.parseInt(birth) > currentDate) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
	}

		public static boolean isLeapYear(int year) {
		    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		}
	
	
	
	//전화번호 유효성 체크
	public static boolean telCheck(String tel) {
        // "-" 제거
        String temp = tel.replaceAll("-", "");

        // 길이가 11인지 확인
        if (temp.length() != 11) {
            return false;
        }

        // 모든 문자가 숫자인지 확인
        for (char t : temp.toCharArray()) {
            if (!Character.isDigit(t)) {
                return false;
            }
        }

        return true;
	}
	



	//이름 유효성 체크
	private static boolean nameCheck(String name) {
		
		 if (name.isEmpty()) {
	            return false; // 빈 문자열인 경우 유효하지 않음
	        }
	        
	        // 정규 표현식: 한글 범위(가-힣)에 맞고 길이가 2에서 12 사이인지 검사
	        String pattern = "^[가-힣]{2,12}$";
	        Pattern regex = Pattern.compile(pattern);
	        Matcher matcher = regex.matcher(name);
	        
	        return matcher.matches();
	    }
        


	//비밀번호 유효성 체크
	private static boolean passwordCheck(String password) {
		
		//길이 제한 10-16자
		 if (password.length() < 10 || password.length() > 16) {
	            return false;
	        }
		 
		 	boolean hasUppercase = false;
	        boolean hasLowercase = false;
	        boolean hasDigit = false;
	        
	        //영어 대문자 소문자 숫자만 포함되는가 
	        for (char p : password.toCharArray()) {
	            if (Character.isUpperCase(p)) {
	                hasUppercase = true;
	            } else if (Character.isLowerCase(p)) {
	                hasLowercase = true;
	            } else if (Character.isDigit(p)) {
	                hasDigit = true;
	            } else {
	                return false; // 다른 문자가 포함되어 있다면 유효하지 않은 비밀번호
	            }
	        }
	        
	        return hasUppercase && hasLowercase && hasDigit;
	    }
	
	//아이디 중복체크
	private static boolean isIdTaken(String id) {
		
		//모든 데이터에 중복이 있는지 체크
		if(UserDbms.searchMemberById(id) == null && UserDbms.searchTeacherById(id) == null && UserDbms.searchAdminById(id) == null) {
			return true;
		}else {
			return false;
		}
		
		
	}

	//아이디 유효성 체크
	private static boolean idCheck(String id) {
		
		//길이 제한 4-16
		int length = id.length();
        if (length < 4 || length > 16) {
            return false;
        }
        
        //영어 소문자 숫자만 포함되는가
        for (char i : id.toCharArray()) {
            if (!Character.isLowerCase(i) && !Character.isDigit(i)) {
                return false;
            }
        }
        
        return true;
		
		
	       
	}
	

}//class