package chap06_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		// 배열에 저장

		BookData bookd = new BookData();
		Book[] books = null;
		int bookCount = 0;
		
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.도서수 입력 2.도서정보 등록 3.도서정보 전체조회 4.도서정보 분석 5.종료");
			System.out.println("------------------------------------------------------");
			
			// 메뉴 선택
			System.out.print("선택 > ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				System.out.print("도서 수 > ");
				bookCount = Integer.parseInt(sc.nextLine());				
				break;
			case 2:
				books = bookd.bookData(bookCount);
				break;
			case 3:
				for(int i = 0; i < books.length; i++) {
					System.out.printf("도서번호 : %d 가격 : %d원",books[i].getBookNum(),books[i].getBookprice());
					System.out.println();
				}
				break;
			case 4:
				int max = 0;
				int min = books[0].getBookprice();
				int sum = 0;
				double avg = 0;
				for(int i = 0; i < books.length; i++) {	
					if (max < books[i].getBookprice()) {
						max = books[i].getBookprice();
					}	
					if (min > books[i].getBookprice()) {
						min = books[i].getBookprice();
					}
					sum += books[i].getBookprice();
					avg = (double)sum / books.length;					
				}
				System.out.printf("최고 가격 : %d\n최저 가격 : %d\n평균 가격는 %.1f점 입니다.\n", max, min, avg);				
				break;
			default:
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
		sc.close();
	}// end main

}//end class
