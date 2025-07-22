package com.jjh.bulletinBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsrDao {
	
	
	
	// 회원가입
	public boolean signUp(String id, String pwd, String name) {
		Connection conn = DBUtil.getConnect();
		// 회원가입 사용자 정보 입력 쿼리
		String query = "insert into usr(id,"
				+ "                     pwd,"
				+ "                     name)"
				+ "     values(?,?,?)";								
				
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			stmt.setString(3, name);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 입력 받은 아이디 사용자 정보 전체 출력
	public ArrayList<Usr> infoUsr(String id){
		Connection conn = DBUtil.getConnect();
		ArrayList<Usr> list = new ArrayList<Usr>();
		// 사용자 정보 출력 쿼리
		String query = "select id,"
				+ "            pwd,"
				+ "            name"
				+ "     from   usr"
				+ "     where  id = ?";
		
		try {
			// ?에 들어갈 내용삽입
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// rs에 넣은 query내용을 리스트에 넣는 과정
			rs.next();
			Usr usr = new Usr();
			usr.setId(rs.getString("id"));
			usr.setPwd(rs.getString("pwd"));
			usr.setName(rs.getString("name"));
			list.add(usr);			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	// id중복체크
	public boolean loginId(String id) {
		Connection conn = DBUtil.getConnect();
		String query = "select id"
				+ "     from   usr"
				+ "     where  id = ?";

		try {
			// ?에 들어갈거를 적는 거
			PreparedStatement stmt = conn.prepareStatement(query);	 
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			// 만약에 일치하는 id와 pwd가 있따면 next가 true출력될꺼고 없다면 next가 false로 출력
			if(rs.next()) {
				return true;
			}
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}// end try catch

		return false;
	}//end loginId
	
	// 로그인 or id와 pwd가 이미 있다면 false로 출력
	public boolean loginUsr(String id, String pwd) {
		Connection conn = DBUtil.getConnect();
		String query = "select id,"
				+ "            pwd"
				+ "     from   usr"
				+ "     where  id = ?"
				+ "       and  pwd = ?";

		try {
			// ?에 들어갈거를 적는 거
			PreparedStatement stmt = conn.prepareStatement(query);	 
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();

			// 만약에 일치하는 id와 pwd가 있따면 next가 true출력될꺼고 없다면 next가 false로 출력
			if(rs.next()) {
				return true;
			}
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}// end try catch

		return false;
	}// end loginusr
}//end class
