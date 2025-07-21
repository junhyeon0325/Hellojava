package com.yedam.app;

import java.util.ArrayList;
import java.util.Scanner;

// 사용자 입력 -> DB반영
// DB결과 -> 콘솔출력
// 컨트롤(제어한다) 역할
public class Main {
	public static void main(String[] args) {
		boolean run = true;	// 반복조건에 사용
		Scanner scn = new Scanner(System.in);	// 스캐너 객체를 scn으로 가져옴
		BookDao dao = new BookDao();	// 조회 기능을 쓸려고 가꼬옴
		while(run) {
			System.out.println("\n도서 관리 시스템");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 도서수정");
			System.out.println("4. 도서삭제");
			System.out.println("9. 종료");
			System.out.print("선택 : ");
			int menu = scn.nextInt();	// 입력값을 menu 변수에 대입(할당)
			switch(menu) {
			case 1:	// 도서목록
				ArrayList<Book> list = dao.findAll();	// 반환: ArrayList<Book>
				System.out.println("도서번호 도서명      저자     가격");
				System.out.println("===========================");
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getId()
							+ " " + list.get(i).getTitle()
							+ " " + list.get(i).getAuthor()
							+ " " + list.get(i).getPrice()
					);	// list는 가고올라면 get을 써야한다
				}// end for
				break;
			case 9:
				run = false;
			}// end switch
		}//end while
		System.out.println("end of program.");
	}//end main
}// end class
