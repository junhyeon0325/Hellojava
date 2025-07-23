package com.jjh.bulletinBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDao {
		
	// 글 작성자 기준 검색
	public ArrayList<Post> postListSearchName(String name) {
		Connection conn = DBUtil.getConnect();	// db연결
		ArrayList<Post> list = new ArrayList<Post>();	// post형식 list 객체 생성
		
		// 글 조회 쿼리
		String query = "select   pnum,"
				+ "              title,"
				+ "              name,"
				+ "              pdate,"
				+ "              pgood,"
				+ "              pview"
				+ "     from     post"
				+ "     where    name like ?"
				+ "     order by pnum";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, "%"+name+"%");
			ResultSet rs = stmt.executeQuery();	
			
			while(rs.next()) {
				Post post = new Post();
				post.setPnum(rs.getInt("pnum"));
				post.setTitle(rs.getString("title"));
				post.setName(rs.getString("name"));
				post.setPdate(rs.getDate("pdate"));
				post.setPgood(rs.getInt("pgood"));
				post.setPview(rs.getInt("pview"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 글 제목 기준 검색
	public ArrayList<Post> postListSearchTitle(String title) {
		Connection conn = DBUtil.getConnect();	// db연결
		ArrayList<Post> list = new ArrayList<Post>();	// post형식 list 객체 생성
		
		// 글 조회 쿼리
		String query = "select   pnum,"
				+ "              title,"
				+ "              name,"
				+ "              pdate,"
				+ "              pgood,"
				+ "              pview"
				+ "     from     post"
				+ "     where    title like ?"
				+ "     order by pnum";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, "%"+title+"%");
			ResultSet rs = stmt.executeQuery();	
			
			while(rs.next()) {
				Post post = new Post();
				post.setPnum(rs.getInt("pnum"));
				post.setTitle(rs.getString("title"));
				post.setName(rs.getString("name"));
				post.setPdate(rs.getDate("pdate"));
				post.setPgood(rs.getInt("pgood"));
				post.setPview(rs.getInt("pview"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 글 시간대로 정렬
	public ArrayList<Post> postListDate() {
		Connection conn = DBUtil.getConnect();	// db연결
		ArrayList<Post> list = new ArrayList<Post>();	// post형식 list 객체 생성
		
		// 글 조회 쿼리
		String query = "select   pnum,"
				+ "              title,"
				+ "              name,"
				+ "              pdate,"
				+ "              pgood,"
				+ "              pview"
				+ "     from     post"
				+ "     order by pdate desc";
		try {
			Statement stmt = conn.createStatement();	// 쿼리를 생성하기 위한 객체를 stmt에 저장
			ResultSet rs = stmt.executeQuery(query);	
			
			while(rs.next()) {
				Post post = new Post();
				post.setPnum(rs.getInt("pnum"));
				post.setTitle(rs.getString("title"));
				post.setName(rs.getString("name"));
				post.setPdate(rs.getDate("pdate"));
				post.setPgood(rs.getInt("pgood"));
				post.setPview(rs.getInt("pview"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}// end postListGood
	
	// 글 추천순대로 정렬
	public ArrayList<Post> postListGood() {
		Connection conn = DBUtil.getConnect();	// db연결
		ArrayList<Post> list = new ArrayList<Post>();	// post형식 list 객체 생성
		
		// 글 조회 쿼리
		String query = "select   pnum,"
				+ "              title,"
				+ "              name,"
				+ "              pdate,"
				+ "              pgood,"
				+ "              pview"
				+ "     from     post"
				+ "     order by pgood desc";
		try {
			Statement stmt = conn.createStatement();	// 쿼리를 생성하기 위한 객체를 stmt에 저장
			ResultSet rs = stmt.executeQuery(query);	
			
			while(rs.next()) {
				Post post = new Post();
				post.setPnum(rs.getInt("pnum"));
				post.setTitle(rs.getString("title"));
				post.setName(rs.getString("name"));
				post.setPdate(rs.getDate("pdate"));
				post.setPgood(rs.getInt("pgood"));
				post.setPview(rs.getInt("pview"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}// end postListGood
	
	// 글 추천
	public boolean postGood(int pgood, int pnum) {
		Connection conn = DBUtil.getConnect();
		String query = "update post"
				+ "     set    pgood = ?"
				+ "     where  pnum = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pgood);
			stmt.setInt(2, pnum);
			
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 글 삭제
	public boolean postDelete(int pnum) {
		Connection conn = DBUtil.getConnect();
		String query = "delete from post"
				+ "     where pnum = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pnum);
			
			ResultSet rs = stmt.executeQuery();			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 조회수 상승
	public boolean postViewUp(int pview, int pnum) {
		Connection conn = DBUtil.getConnect();
		String query = "update post"
				+ "     set    pview = ?"
				+ "     where  pnum = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pview);
			stmt.setInt(2, pnum);
			
			int rs = stmt.executeUpdate();
			if(rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 글 내용 조회
	public Post postView(int pnum) {
		Connection conn = DBUtil.getConnect();
		Post postv = new Post();
		String query = "select pnum,"
				+ "            title,"
				+ "            content,"
				+ "            pgood,"
				+ "            pview"
				+ "     from   post"
				+ "     where  pnum = ?";		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pnum);			
			
			// postv에 title과 content를 넣어서 return해주기
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			postv.setTitle(rs.getString("title"));
			postv.setContent(rs.getString("content"));
			postv.setPview(rs.getInt("pview"));
			postv.setPgood(rs.getInt("pgood"));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return postv;
	}
	
	// 글 수정하기
	public boolean postUpdate(int pnum, String title, String content) {
		Connection conn = DBUtil.getConnect();
		String query = "update post"
				+ "     set    title = ?,"
				+ "            content = ?"
				+ "     where  pnum = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, pnum);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 글 등록할때 글 번호의 아이디와 접속중인 아이디가 다른 경우
	public boolean postId(int pnum, String id) {
		Connection conn = DBUtil.getConnect();
		String query = "select *"				// 쿼리문 작성
				+ "     from   post"
				+ "     where  pnum = ?"
				+ "       and  id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pnum);
			stmt.setString(2, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {		// 줄이 있다는 의미는 입력받은 pnum의 id와 디비에 있는 pnum의 id가 같다는 의미
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// 글 등록할때 글번호가 겹치지 않게 중복체크
	public boolean postNum(int pnum) {
		Connection conn = DBUtil.getConnect();
		String query = "select pnum"
				+ "     from   post"
				+ "     where pnum = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, pnum);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return true;
	}// end postId
	
	// 글 등록하기
	public boolean postInsert(int pnum, String title, String name, String id, String content) {
		Connection conn = DBUtil.getConnect();	// db연결
		String query = "insert into post (pnum,"	// 글 삽입 쿼리
				+ "                      title,"
				+ "                      name,"
				+ "                      pdate,"
				+ "                      id,"
				+ "                      content)"
				+ "     values(?, ?, ?, sysdate, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);	// ?에 넣는 과정
			stmt.setInt(1, pnum);
			stmt.setString(2, title);
			stmt.setString(3, name);
			stmt.setString(4, id);
			stmt.setString(5, content);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
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
				+ "     from   post"
				+ "     order by pnum";
		try {
			Statement stmt = conn.createStatement();	// 쿼리를 생성하기 위한 객체를 stmt에 저장
			ResultSet rs = stmt.executeQuery(query);	
			
			while(rs.next()) {
				Post post = new Post();
				post.setPnum(rs.getInt("pnum"));
				post.setTitle(rs.getString("title"));
				post.setName(rs.getString("name"));
				post.setPdate(rs.getDate("pdate"));
				post.setPgood(rs.getInt("pgood"));
				post.setPview(rs.getInt("pview"));
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}// end postListCheck
}// end class
