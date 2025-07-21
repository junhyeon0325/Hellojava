package com.yedam.app;

import java.util.ArrayList;
import java.util.Scanner;

// 사용자 입력 -> DB반영
// DB결과 -> 콘솔출력
// 컨트롤(제어한다) 역할
public class Main {
	public static void main(String[] args) {
		boolean run = true; // 반복조건에 사용
		Scanner scn = new Scanner(System.in); // 스캐너 객체를 scn으로 가져옴
		BookDao dao = new BookDao(); // 조회 기능을 쓸려고 가꼬옴
		while (run) {
			System.out.println("\n도서 관리 시스템");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 도서수정");
			System.out.println("4. 도서삭제");
			System.out.println("5. 단건조회");
			System.out.println("9. 종료");
			System.out.print("선택 : ");
			int menu = scn.nextInt(); // 입력값을 menu 변수에 대입(할당)
			switch (menu) {
			case 1: // 도서목록
				ArrayList<Book> list = dao.findAll(); // 반환: ArrayList<Book>
				System.out.println("도서번호 도서명      저자     가격");
				System.out.println("===========================");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getId() + " " + list.get(i).getTitle() + " "
							+ list.get(i).getAuthor() + " " + list.get(i).getPrice()); // list는 가고올라면 get을 써야한다
				} // end for
				break;

			case 2: // 도서등록.
				System.out.print("도서번호>> ");
				int bno = scn.nextInt();
				scn.nextLine(); // 반환값이 int. 1003엔터를 치면은 1003값만 읽어들여서 bno에 들어가고 엔터는 처리가 안됨 엔터는 nextline에서 처리가 됨
								// 그래서 도서저자까지 넘어가버림
				System.out.print("도서제목>> ");
				String title = scn.nextLine(); // 반환값이 String.
				System.out.print("도서저자>> ");
				String author = scn.nextLine(); // 반환값이 String.
				System.out.print("도서가격>> ");
				int price = scn.nextInt();
				scn.nextLine(); // 반환값이 int.

				Book book = new Book(bno, title, author, price); // book
				if (dao.insert(book)) { // dao.insert(book)반환값이 boolean이라서 true면 위에꺼 false면 else꺼
					System.out.println("정상 등록.");
				} else {
					System.out.println("등록 중 오류");
				}
				break;

			case 3:
				System.out.print("도서번호>> ");
				bno = scn.nextInt();
				scn.nextLine();
				System.out.print("도서가격>> ");
				price = scn.nextInt();
				scn.nextLine(); // 반환값이 int.

				if (dao.update(bno, price)) {
					System.out.println("정상 수정.");
				} else {
					System.out.println("등록 중 오류");
				}
				break;

			case 4:	// 도서삭제
				System.out.print("도서번호>> ");
				bno = scn.nextInt();
				scn.nextLine();

				if (dao.delete(bno)) {
					System.out.println("정상 삭제.");
				} else {
					System.out.println("삭제 중 오류");
				}
				break;
				
			case 5:
				System.out.print("도서번호>> ");
				bno = scn.nextInt();
				scn.nextLine();		
				
				ArrayList<Book> list1 = dao.findByID(bno);
				
				System.out.println("도서번호 도서명      저자     가격");
				System.out.println("===========================");
				System.out.println(list1.get(0).getId() + " " + list1.get(0).getTitle() + " "
						+ list1.get(0).getAuthor() + " " + list1.get(0).getPrice());				
				break;
				
			case 9:
				run = false;
			}// end switch
		} // end while
		System.out.println("end of program.");
	}// end main
}// end class
