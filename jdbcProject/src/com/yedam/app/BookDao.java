package com.yedam.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 조회, 등록, 수정, 삭제
public class BookDao {
	// 단건조회
	public ArrayList<Book> findByID(int bno) {
		Connection conn = DBUtil.getConnect();
		ArrayList<Book> list1 = new ArrayList<Book>();
		String query = "select id, title, author, price" 
+ "     from book" 
+ "     where id = " + bno;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getInt("price"));
			list1.add(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}

	// 숙제 : 삭제(delete), 단건조회(findById) 작성해보세용.
	public boolean delete(int bno) { // return값은 boolean으로, 받는 매개변수는 책번호로
		Connection conn = DBUtil.getConnect(); // DBUtil과 연결
		String query = "delete from book" + "     where id = ?"; // delete 쿼리를 적어서 query변수에 저장
		try {
			PreparedStatement stmt = conn.prepareStatement(query); // 예외처리, ?에 들어갈 방식을 지정
			stmt.setInt(1, bno);

			int r = stmt.executeUpdate(); // executeUpdate()는 INSERT, UPDATE, DELETE와 같은 DML(Data Manipulation
											// Language)에서 실행 결과로 영향을 받은 레코드 수를 반환한다.
			if (r > 0) { // 0보다 크다는 것은 실행 결과로 영향을 받은 쿼리가 있다는 의미
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 수정. 매개값(int bno, int price), 반환값(boolean)
	public boolean update(int bno, int price) {
		Connection conn = DBUtil.getConnect();
		String query = "update book" + "     set price = ?" + "     where id = ?";

//		System.out.println(query);
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, price);
			stmt.setInt(2, bno);

			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end update

	// 등록. 매개값(Book), 반환값(boolean)
	// insert 등록
	public boolean insert(Book book) {
		Connection conn = DBUtil.getConnect();
		String query = "insert into book (id, title, author, price)"// // 너무길어서 쿼리가 그래서 이렇게 따로 뺌
				+ "		values(?,?,?,?)"; // ?는 값이 아직 안정해졌다,
		System.out.println(query);
		try {
			PreparedStatement stmt = conn.prepareStatement(query); // PreparedStatment 가 ?에 들어갈 방식을 정해준다
			stmt.setInt(1, book.getId()); // ?의 첫번째에 값을 지정
			stmt.setString(2, book.getTitle()); // ?의 두번째에 값을 지정
			stmt.setString(3, book.getAuthor()); // ?의 세번째에 값을 지정
			stmt.setInt(4, book.getPrice()); // ?의 네번째에 값을 지정

			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과
			if (r > 0) { // 한건 입력되면...
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 일단 에러 없는 상태로 만들기 위해 return값을 false로 만들어놈
	}

	// 목록조회(다건)
	// 메소
	public ArrayList<Book> findAll() { // arraylist클래스를 임포트, 리턴값을 지정해줘야 findall밑에 빨간줄 없어짐
		Connection conn = DBUtil.getConnect(); // static이니까 이게 가능
		ArrayList<Book> list = new ArrayList<Book>(); // 컬렉션(Book) 리스트 생성
		try {
			Statement stmt = conn.createStatement(); // 예외처리 무조건 해야함, 쿼리를 실행하기 위한 객체
			ResultSet rs = stmt.executeQuery("select * from book"); // 쿼리 선언, ResultSet는 쿼리를 실하면 결과값을 가져오는 객체

			// 반복
			while (rs.next()) { // SQL문을 통해 얻은 데이터에서 첫번째행에서 마지막 행까지를 추출할때나 행이 있는지 없는지 판단할때주로 while문을 통해
								// rs.next()가 사용된다.
				Book book = new Book(); // 기본 생성자가 있으면 에러가 사라짐(Book클래스에)
				book.setId(rs.getInt("id")); // 커서가 가리치고 있는 커서중에서 id가 담겨있는데이터중에서 id 필드에 할당
				book.setTitle(rs.getString("title")); // title에 담겨있는 값을 setTitle 필드에 전달
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
