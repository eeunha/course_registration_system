package com.project.courseinfo;

import java.util.Scanner;

public class CourseList {

	static Scanner scan = new Scanner(System.in);

	//강좌 목록 선택시 출력 멘트
	public static void lectureListMent() {

		courseList();

		boolean loop = true;
		boolean loop1 = true;
		boolean loop2 = true;
		
		while (loop) {
			
			String input = scan.nextLine();			
			
			if (input.equals("0")) {
				loop = false;
			} else if (input.equals("1")) {
				System.out.println("======================");
				System.out.println("전체 강좌");
				System.out.println("======================");
				CourseData.allList();
				
				System.out.println();
				System.out.println("0.뒤로가기");
				System.out.print("입력: ");
				
				
				while (loop1) {
					
					input = scan.nextLine();

					if (input.equals("0")) {
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
						courseList();
						loop1 = false;
					} else {
						System.out.println("뒤로 가려면 0번을 눌러주세요.");
						System.out.print("입력: ");
					}					
				}
				
				
			} else if (input.equals("2")) {
				
				categoryView();
				
				while (loop1) {
					
					input = scan.nextLine();
					
					if (input.equals("0")) {
						
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
						courseList();
						loop1 = false;
						
					} else if (input.equals("1")) {
						CourseData.cultureList();
						
						System.out.println("0.뒤로가기");
						System.out.print("입력: ");
						
						while (loop2) {
							
							input = scan.nextLine();
							
							if (input.equals("0")) {
								System.out.println("뒤로 돌아갑니다.");
								System.out.println();
								loop2 = false;
								categoryView();
							} else {
								System.out.println("뒤로 가려면 0번을 눌러주세요.");
								System.out.print("입력: ");
							}
						}
						
						
					} else if (input.equals("2")) {
						CourseData.pianoList();
						
						System.out.println("0.뒤로가기");
						System.out.print("입력: ");
						
						while (loop2) {
							
							input = scan.nextLine();
							
							if (input.equals("0")) {
								System.out.println("뒤로 돌아갑니다.");
								System.out.println();
								loop2 = false;
								categoryView();
							} else {
								System.out.println("뒤로 가려면 0번을 눌러주세요.");
								System.out.print("입력: ");
							}
						}
						
					} else if (input.equals("3")) {
						CourseData.sportsList();
						
						System.out.println("0.뒤로가기");
						System.out.print("입력: ");
						
						while (loop2) {
							
							input = scan.nextLine();
							
							if (input.equals("0")) {
								System.out.println("뒤로 돌아갑니다.");
								System.out.println();
								loop2 = false;
								categoryView();
							} else {
								System.out.println("뒤로 가려면 0번을 눌러주세요.");
								System.out.print("입력: ");
							}
						}
						
					} else if (input.equals("4")) {
						CourseData.kidsList();
						
						System.out.println("0.뒤로가기");
						System.out.print("입력: ");
						
						while (loop2) {
							
							input = scan.nextLine();
							
							if (input.equals("0")) {
								System.out.println("뒤로 돌아갑니다.");
								System.out.println();
								loop2 = false;
								categoryView();
							} else {
								System.out.println("뒤로 가려면 0번을 눌러주세요.");
								System.out.print("입력: ");
							}
						}
						
					} else if (input.equals("5")) {
						CourseData.blockList();
						
						System.out.println("0.뒤로가기");
						System.out.print("입력: ");
						
						while (loop2) {
							
							input = scan.nextLine();
							
							if (input.equals("0")) {
								System.out.println("뒤로 돌아갑니다.");
								System.out.println();
								loop2 = false;
								categoryView();
							} else {
								System.out.println("뒤로 가려면 0번을 눌러주세요.");
								System.out.print("입력: ");
							}
						}
					} else {
						System.out.println("잘못된 번호입니다.");
						System.out.print("입력: ");
					}
				}
				
				
			} else if (input.equals("3")) {
				System.out.println("======================");
				System.out.println("요일/시간별 강좌");
				System.out.println("======================");
				System.out.println("0. 뒤로가기");
				System.out.println("1. 요일 선택");
				// 전체 강좌 가져오는 데이터, for문으로 5~10개 씩 끊어서 출력하고
				// 만약 1을 입력하면 이전 페이지 2를 입력 하면 다음 페이지를 보여준다.
				// 0번 입력시 뒤로가기
				System.out.println();
				System.out.println("입력: ");
				
				while (loop1) {
					
					input = scan.nextLine();
					
					if (input.equals("0")) {
						
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
						courseList();
						loop1 = false;
						
					} else if (input.equals("1")) {
						weekOfDay();
						
						while (loop2) {
							
							input = scan.nextLine();
							
							if (input.equals("0")) {
								
								System.out.println("뒤로 돌아갑니다.");
								System.out.println();
								weekOfDay();
								loop2 = false;
								
							} else if (input.equals("1")) {
								System.out.println("=====================");
								System.out.println("0. 뒤로가기");
								System.out.println("1.오전");
								System.out.println("2.오후");
								input = scan.nextLine();
								
								if (input.equals("0")) {
									
									System.out.println("뒤로 돌아갑니다.");
									System.out.println();
									
								} else if (input.equals("1")) {
									CourseData.mondayAmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
										
									}
									
								} else if (input.equals("2")) {
									CourseData.mondayPmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
										
									}
								}
								
							} else if (input.equals("2")) {
								System.out.println("=====================");
								System.out.println("0. 뒤로가기");
								System.out.println("1.오전");
								System.out.println("2.오후");
								input = scan.nextLine();
								
								if (input.equals("0")) {
									System.out.println("뒤로 돌아갑니다.");
									System.out.println();
								} else if (input.equals("1")) {
									CourseData.tuesdayAmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
									
								} else if (input.equals("2")) {
									CourseData.tuesdayPmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
								}
								
							} else if (input.equals("3")) {
								System.out.println("=====================");
								System.out.println("0. 뒤로가기");
								System.out.println("1.오전");
								System.out.println("2.오후");
								input = scan.nextLine();
								
								if (input.equals("0")) {
									System.out.println("뒤로 돌아갑니다.");
									System.out.println();
								} else if (input.equals("1")) {
									CourseData.wednesdayAmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
									
								} else if (input.equals("2")) {
									CourseData.wednesdayPmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
								}
								
							} else if (input.equals("4")) {
								System.out.println("=====================");
								System.out.println("0. 뒤로가기");
								System.out.println("1.오전");
								System.out.println("2.오후");
								input = scan.nextLine();
								
								if (input.equals("0")) {
									System.out.println("뒤로 돌아갑니다.");
									System.out.println();
								} else if (input.equals("1")) {
									CourseData.thursdayAmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
									
								} else if (input.equals("2")) {
									CourseData.thursdayPmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
								}
								
							} else if (input.equals("5")) {
								System.out.println("=====================");
								System.out.println("0. 뒤로가기");
								System.out.println("1.오전");
								System.out.println("2.오후");
								input = scan.nextLine();
								
								if (input.equals("0")) {
									System.out.println("뒤로 돌아갑니다.");
									System.out.println();
									
								} else if (input.equals("1")) {
									CourseData.fridayAmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
									
								} else if (input.equals("2")) {
									CourseData.fridayPmTime();
									
									System.out.println("0. 뒤로가기");
									input = scan.nextLine();
									
									if (input.equals("0")) {
										System.out.println("뒤로 돌아갑니다.");
										System.out.println();
									}
								}
							
						}
						
						}
						
					}
				}
				
				
			} else if (input.equals("4")) {
				System.out.println();
				System.out.println("======================");
				System.out.println("연령층별 강좌");
				System.out.println("======================");
				System.out.println("1. 어린이");
				System.out.println("2. 청소년");
				System.out.println("3. 성인");
				System.out.println("4. 누구나");
				System.out.println();
				System.out.println("0.뒤로가기");
				System.out.println("입력: ");
				input = scan.nextLine();
				
				if (input.equals("0")) {
					System.out.println("뒤로 돌아갑니다.");
					System.out.println();
					courseList();
					
				} else if (input.equals("1")) {
					
					CourseData.child();
					
					System.out.println("0. 뒤로가기");
					input = scan.nextLine();
					
					if (input.equals("0")) {
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
					}
				} else if (input.equals("2")) {
					
					CourseData.teenager();
					
					System.out.println("0. 뒤로가기");
					input = scan.nextLine();
					
					if (input.equals("0")) {
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
					}
					
				} else if (input.equals("3")) {
					
					CourseData.adult();
					
					System.out.println("0. 뒤로가기");
					input = scan.nextLine();
					
					if (input.equals("0")) {
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
					}
					
				} else if (input.equals("4")) {
					
					CourseData.everyone();
					
					System.out.println("0. 뒤로가기");
					input = scan.nextLine();
					
					if (input.equals("0")) {
						System.out.println("뒤로 돌아갑니다.");
						System.out.println();
						
					}
					
				}
			} else {
				System.out.println("목록에 있는 번호를 입력하세요.");
				System.out.print("입력: ");
				input = scan.nextLine();
			}
			
		}
		

	}

	public static void weekOfDay() {
		System.out.println("=====================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 월");
		System.out.println("2. 화");
		System.out.println("3. 수");
		System.out.println("4. 목");
		System.out.println("5. 금");
		System.out.println();
		System.out.println("입력: ");
	}

	public static void categoryView() {
		System.out.println();
		System.out.println("======================");
		System.out.println("카테고리별 강좌");
		System.out.println("======================");
		System.out.println("1.문화");
		System.out.println("2.피아노");
		System.out.println("3.체육");
		System.out.println("4.어린이");
		System.out.println("5.블럭교실");
		System.out.println();
		System.out.println("0.뒤로가기");
		System.out.print("입력: ");
	}

	public static void courseList() {
		System.out.println();
		System.out.println("============================");
		System.out.println("강좌 목록");
		System.out.println("============================");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 전체강좌 보기");
		System.out.println("2. 카테고리별 강좌 보기");
		System.out.println("3. 요일/시간별 강좌 보기");
		System.out.println("4. 연령층별 보기");
		System.out.println("----------------------------------");

		System.out.print("번호 입력: ");
	}
}