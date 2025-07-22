package com.jjh.bulletinBoard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDao {
	
	// 글 목록 조회
	public ArrayList<Post> postListCheck() {
		Connection conn = DBUtil.getConnect();	// db연결
		ArrayList<Post> list = new ArrayList<Post>();	// post형식 list 객체 생성
		
		// 글 조회 쿼리
		String query = "select pnum,"
				+ "            title,"
				+ "            name,"
				+ "            pdate,"
				+ "            pgood,"
				+ "            pview"
				+ "     from   post";
		try {
			Statement stmt = conn.createStatement();	// 쿼리를 생성하기 위한 객체를 stmt에 저장
			ResultSet rs = stmt.executeQuery(query);	// 
			
			while(rs.next()) {
				Post post = new Post();
				post.setPnum(rs.getInt("pnum"));
				post.setTitle(rs.getString("title"));
				post.setName(rs.getString("name"));
				post.setPdate(rs.getDate("pdate"));
				post.setPgood(rs.getInt("pview"));
				post.setPview(rs.getInt("pview"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}// end postListCheck
}// end class
