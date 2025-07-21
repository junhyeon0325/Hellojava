package chap06_1;

import java.util.Scanner;

public class BookData {
	Scanner sc = new Scanner(System.in);
	//필드:field
	//생성자:constructor
	//메소드:method
	Book[] bookData(int n) {
		Book[] books = new Book[n];
//				new Book(1234, "리어왕", 25600),
//				new Book(4567, "오셀로", 15800),
//				new Book(7890, "햄릿", 37890)
		for(int i = 0; i < n; i++) {										
			System.out.printf("%d 번째 도서 정보 입력\n",i+1);
			
			System.out.print("도서번호 > ");
			int bookNum = Integer.parseInt(sc.nextLine());
			
			System.out.print("도서제목 > ");
			String bookName = sc.nextLine();
			
			System.out.print("도서가격 > ");
			int bookprice = Integer.parseInt(sc.nextLine());					
			
			books[i] = new Book(bookNum, bookName, bookprice);
		}
		
	return books;
	}
}// end class
