package com.yedam.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 조회, 등록, 수정, 삭제
public class BookDao {
	// 목록조회(다건)
	public ArrayList<Book> findAll() {	// arraylist클래스를 임포트, 리턴값을 지정해줘야 findall밑에 빨간줄 없어짐
		Connection conn = DBUtil.getConnect();	// static이니까 이게 가능
		ArrayList<Book> list = new ArrayList<Book>();	// 컬렉션(Book) 리스트 생성
		try {
			Statement stmt = conn.createStatement();	// 예외처리 무조건 해야함, 쿼리를 실행하기 위한 객체
			ResultSet rs = stmt.executeQuery("select * from book");	// 쿼리 선언, ResultSet는 쿼리를 실하면 결과값을 가져오는 객체

			// 반복
			while(rs.next()) {	//SQL문을 통해 얻은 데이터에서 첫번째행에서 마지막 행까지를 추출할때나 행이 있는지 없는지 판단할때주로 while문을 통해 rs.next()가 사용된다.
				Book book = new Book();		// 기본 생성자가 있으면 에러가 사라짐(Book클래스에)
				book.setId(rs.getInt("id"));	// 커서가 가리치고 있는 커서중에서 id가 담겨있는데이터중에서 id 필드에 할당
				book.setTitle(rs.getString("title"));	// title에 담겨있는 값을 setTitle 필드에 전달
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				// 컬렉션에 추가
				list.add(book);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return list;
	}// end findAll()
}// end class BookDao
