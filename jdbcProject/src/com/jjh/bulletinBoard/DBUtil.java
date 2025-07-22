package com.jjh.bulletinBoard;

import java.sql.Connection;	// 데이터베이스 연결 하기위한 임포트
import java.sql.DriverManager;


public class DBUtil {
	public static Connection getConnect() {	// 리턴값이 Connection타입
		Connection conn = null;	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// jdbc에서 driver클래스를 jvm에 로드하기위해 사용
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {	// ClassNotFoundException 원레는 이거였는데 drivermanger구문도 예외처리 할려고 exception으로 바꿈
			e.printStackTrace();
		}		
		return conn;
	}
}
