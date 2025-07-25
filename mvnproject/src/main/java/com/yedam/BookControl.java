package com.yedam;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;

// 목록.
// 단건
// 등록
public class BookControl {

	Scanner scn = new Scanner(System.in);
	SqlSession sqlSession = DBUtil.getInstance().openSession();
//						sql팩토리 생성			sql 섹션 접근
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("도서정보");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 상세조회");
			System.out.println("0. 이전메뉴");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 목록.
				bookList();
				break;
			case 2: // 등록
				addBook();
				break;
			case 0:
				return; // 메소드 종료
			default:
				System.out.println("메뉴를 선택하세요.");
			}
		}
	}// end of exe();

	void bookList() {
		int page = 1;
		while (true) {
			List<Book> list = mapper.selectList(page);
			// id / title / price
			System.out.println("===================");
			System.out.println("도서ID 도서제목    가격");
			System.out.println("===================");
			for (Book book : list) {
				System.out.println(book.showBrief());
			}
			System.out.println("이전(p) 다음(n) 선택>> ");
			String p = scn.nextLine();
			if(p.equals("n")) {
				page++;
			} else if(p.equals("p")){
				page--;
			}
		}
//		bookSearch();	// 상세조회
	} // end of bookList().

	void addBook() {
		System.out.println("도서ID입력>> ");
		String id = scn.nextLine();
		System.out.println("도서제목>> ");
		String title = scn.nextLine();
		System.out.println("도서저자>> ");
		String author = scn.nextLine();
		System.out.println("도서가격>> ");
		String price = scn.nextLine();

		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Integer.parseInt(price));

		if (mapper.insertBook(book) == 1) {
			sqlSession.commit(); // 커밋처리.
			System.out.println("성공!!");
		}
	} // end of addBook().

	void bookSearch() {
		// 상세조회
		while (true) {
			System.out.println("===================");
			System.out.println("상세보기(ID입력), 취소(q) 선택>> ");
			// try 블럭 실행하다가 예외 발생하면 catch 블럭을 실행.
			try {
				int bno = Integer.parseInt(scn.nextLine()); // "q"
				Book book = mapper.selectBook(bno);
				if (book == null) {
					System.out.println("검색결과 없음.");
				} else {
					System.out.println(book.showDetail());
					System.out.println("삭제할래요? y/N");
					String flag = scn.nextLine();
					if (flag.equals("") || flag.equals("N")) {
						// 삭제안함
						continue;
					}
					// 삭제가능.
					if (mapper.deleteBook(bno) == 1) {
						sqlSession.commit();
						System.out.println("성공!!");
						break; // break를 딱 찍으면 하이라이트가 어디서 끝나는지 보임
					}
				}
			} catch (NumberFormatException e) {
				return;
			}

		} // end of while.
	}// end of bookSearch
}
