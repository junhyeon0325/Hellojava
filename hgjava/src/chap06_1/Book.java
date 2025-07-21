package chap06_1;

public class Book {
	// 필드 : field
	private int bookNum;
	private	String bookName;
	private int bookprice;
	
	public int getBookNum() {
		return bookNum;
	}

	public String getBookName() {
		return bookName;
	}

	public int getBookprice() {
		return bookprice;
	}

	// 생성자 : constructor
	Book(int bookNum, String bookName, int bookprice){
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookprice = bookprice;
	}
	// 메소드 : method
	
	
	
}// end class
