package com.jjh.bulletinBoard;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Connection conn = DBUtil.getConnect();
		
		// id와 pwd 먼저선언
		String id = "";
		String pwd = "";
		String name = "";
		
		while(run) {
			Scanner sc = new Scanner(System.in);
			UsrDao dao = new UsrDao();
			
			// 기능들 목록들 출력
			System.out.println("------------------------");
			System.out.println("0. 로그인");	// 아이디 패스워드 맞는지, 틀렸는지 체크
			System.out.println("1. 글목록보기");
			System.out.println("2. 글등록하기");
			System.out.println("3. 글수정하기");	// 다른 사용자는 수정할수 없게
			System.out.println("4. 글내용조회하기");	// 조회수도 같이 올라가도록
			System.out.println("5. 글삭제하기");	// 다른 사용자는 삭제할수 없도록
			System.out.println("6. 글추천하기");
			System.out.println("7. 추천, 최근글 순으로 보기");
			System.out.println("8. 글 검색하기");
			System.out.println("10. 회원가입");	// 아이디가 이미 있습니다.
			System.out.println("11. 현재접속한 아이디 확인");	
			System.out.println("12. 종료");
			System.out.println("------------------------");
			// 기능 번호 입력
			System.out.print("실행할 목록번호를 입력해주세요>> ");
			int blist = sc.nextInt();
			sc.nextLine();
			
			// 목록 출력
			switch(blist) {
			case 0:		// 로그인 기능
				// 아이디, 비번 입력
				System.out.print("아이디 입력 : ");
				id = sc.nextLine();
				System.out.print("비밀번호 입력 : ");
				pwd = sc.nextLine();
				
				// 로그인 메세지 출력
				if(dao.loginUsr(id, pwd)) {		// false면 else문 true면 성공
					System.out.println("로그인 성공했습니다.");
					
					// 로그인을 할때 아이디에 맞는 행의 이름을 변수에 넣음
					ArrayList<Usr> list = dao.infoUsr(id);
					name = list.get(0).getName();					
				} else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
					id = "";
					pwd = "";
				}						
				break;
			case 10:	// 회원가입
				System.out.println("회원가입입니다.");
				
				// 아이디, 비번, 이름 입력
				System.out.print("아이디 입력 : ");
				String nid = sc.nextLine();
				System.out.print("비밀번호 입력 : ");
				String npwd = sc.nextLine();
				System.out.print("이름 입력 : ");
				String nname = sc.nextLine();	

				// 아이디 중복 확인
				if(dao.loginId(nid)) {
					System.out.println("이미 존재하고 있는 아이디 입니다.\n다른아이디를 입력해주세요.");
					break;
				}
				
				// 회원가입 성공 or 회원가입 실패
				if(dao.signUp(nid, npwd, nname)) {
					System.out.println("회원가입 성공!");					
				} else {
					System.out.println("회원가입 실패!");
				}
				
				break;
			case 11:	// 현재 접속한 아이디 확인				
				// 로그인을 하지 않았다면 id가 빈공간일테니 로그인하라고 말해줌, 반대로 했다면 아이디와 이름 출력
				if(id.equals("")) {
					System.out.println("현재 계정 정보 조회 실패!");
					System.out.println("로그인을 해주세요!");
				} else {
					System.out.println("현재 계정 정보 입니다.");
					ArrayList<Usr> list = dao.infoUsr(id);
					System.out.printf("아이디 : %s\n", list.get(0).getId());
					System.out.printf("비밀번호 : %s\n", list.get(0).getPwd());
					System.out.printf("이름 : %s\n", list.get(0).getName());
				}				
				break;
			default:	// 종료 기능
				System.out.println("종료되었습니다.");
				run = false;
			}//end switch
		}//end while				
	}//end main

}//end class
