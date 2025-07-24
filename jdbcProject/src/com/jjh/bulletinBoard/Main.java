package com.jjh.bulletinBoard;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Connection conn = DBUtil.getConnect();
		Scanner sc = new Scanner(System.in);
		UsrDao dao = new UsrDao();
		PostDao daop = new PostDao();
		
		// id와 pwd 먼저선언
		String id = "";
		String pwd = "";	
		String name = "";
		
		while(run) {
			
			// 기능들 목록들 출력
			System.out.println("=========================");
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
			System.out.println("12. 로그아웃");
			System.out.println("13. 종료");
			System.out.println("=========================");
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
				
			case 1:		// 글목록보기
				// 글목록 출려하기 위한 리스트 선언
				ArrayList<Post> listp = daop.postListCheck();
				
				System.out.println("------------------------------------------------------------");
				System.out.println(" 글번호 | 1. 제목 | 2. 작성자 | 3. 작성일시 | 4. 추천수 | 5. 조회수");
				System.out.println("------------------------------------------------------------");
				
				// 글목록 출력하는 반복문
				for(int i = 0; i < listp.size(); i++) {
					System.out.println(" " + listp.get(i).getPnum() + " | 1. " + listp.get(i).getTitle()
							+ " | 2. " + listp.get(i).getName() + " | 3. " + listp.get(i).getPdate()
							+ " | 4. " + listp.get(i).getPgood() + " | 5. " + listp.get(i).getPview());
				}// end for
				break;
				
			case 2:		// 글등록하기
				// 만약에 로그인이 안되어 있으면 로그인하라고 뜨기
				if(id.equals("")) {
					System.out.println("로그인을 먼저 해주세요.");
					break;
				}
				
				// 글 등록 문장들 출력
				// 글번호 입력 및 글번호가 이미 있으면 중복이라고 알려주는 코드
				System.out.print("글번호입력>> ");
				int pnum = sc.nextInt();
				if(daop.postNum(pnum) == false) {
					System.out.println("글 번호 중복입니다!\n목록을 확인하시고 다른 번호를 입력해주세요.");
					break;
				}
				// 나머지 글 등록 문장들 출력
				sc.nextLine();
				System.out.print("글제목입력>> ");
				String ptitle = sc.nextLine();
				System.out.print("글내용입력>> ");
				String pct = sc.nextLine();
				
				// 글 저장 완료 및 실패 출력
				if(daop.postInsert(pnum, ptitle, name, id, pct)) {
					System.out.println("저장완료!");
				} else {
					System.out.println("저장실패!");
				}
				break;
			
			case 3:		// 글 수정하기
				// 만약에 로그인이 안되어 있으면 로그인하라고 뜨기
				if(id.equals("")) {
					System.out.println("로그인을 먼저 해주세요.");
					break;
				}
				
				// 수정하고싶은 글 번호 입력
				System.out.print("수정할 글 번호를 입력해 주세요>> ");
				int punum = sc.nextInt();
				sc.nextLine();
				
				// 없는 번호 입력시 경고문 후 빠져나감
				if(daop.postNum(punum)) {
					System.out.println("글 번호가 없습니다.\n목록을 확인하시고 번호를 입력해주세요.");
					break;
				}
				
				// 글 번호의 아이디와 현재 접속중인 아이디가 다른경우 경고문 후 빠져나감
				if(daop.postId(punum, id)) {
					System.out.println("글을 작성한 id와 다르므로 수정할 수 없습니다.");
					break;
				}
				
				// 나머지 글 수정 출력
				System.out.print("글 제목 수정>> ");
				String putitle = sc.nextLine();
				System.out.print("글 내용 수정>> ");
				String pucontent = sc.nextLine();
						
				// 글 수정 완료 및 실패 출력
				if(daop.postUpdate(punum, putitle, pucontent)) {
					System.out.println("글 수정 완료!");					
				} else {
					System.out.println("글 수정 실패!");					
				}
				break;
			
			case 4:		// 글 내용 조회하기				
				System.out.print("글 번호 입력>> ");
				int pvnum = sc.nextInt();
				sc.nextLine();
								
				// 입력받은 글 번호가 있는지 확인
				if(daop.postNum(pvnum)) {
					System.out.println("글 조회 실패!");	
					break;
				}
								
				// 글 내용 조회 및 조회수 상승
				Post postv = daop.postView(pvnum);
				int pview = postv.getPview();
				++pview;				
				daop.postViewUp(pview, pvnum);
				System.out.println("글 조회 및 조회수 상승 완료");
				System.out.print("글 제목 : " + postv.getTitle());
				System.out.print("\n글 내용 : " + postv.getContent());
				System.out.println();
				break;
				
			case 5:		// 글 삭제
				// 만약에 로그인이 안되어 있으면 로그인하라고 뜨기
				if(id.equals("")) {
					System.out.println("로그인을 먼저 해주세요.");
					break;
				}
				
				System.out.print("글 번호 입력>> ");
				int pdnum = sc.nextInt();
				sc.nextLine();
				
				if(daop.postId(pdnum, id)) {
					System.out.println("글을 작성한 id와 다르므로 삭제할 수 없습니다.");
					break;
				}
				
				System.out.print("정말로 삭제하시겠습니까? (y/n) ");
				String pdc = sc.nextLine();
				if(pdc.equals("y")) {
					if(daop.postDelete(pdnum)) {
						System.out.println("삭제 완료!!");
					}
				} else {
					System.out.println("삭제 취소!!");
					break;
				}
				break;
				
			case 6:		// 글추천하기
				System.out.print("추천할 글번호 입력>> ");
				int pgnum = sc.nextInt();
				
				// 없는 번호 입력시 경고문 후 빠져나감
				if(daop.postNum(pgnum)) {
					System.out.println("글 번호가 없습니다.\n목록을 확인하시고 번호를 입력해주세요.");
					break;
				}
				
				// 추천할 글의 현재추천수를 main으로 부르고 추천수를 증가시켜서 
				Post pg = daop.postView(pgnum);
				int pgood = pg.getPgood();
				++pgood;
				
				// db에 넣고 성공했으면 true
				if(daop.postGood(pgood, pgnum)) {
					System.out.println(pgnum + "번글 추천 완료!");					
				} else {
					System.out.println("추천 실패");				
				}
				break;
				
			case 7:		// 추천글 순서로 보기 or 최근글 순서로 보기
				// 글 순서 정하기 출력
				System.out.println("1. 추천글 순서로 보기");
				System.out.println("2. 최근글 순서로 보기");
				System.out.println("3. 나가기");
				System.out.print("글 순서를 선택해주세요>> ");
				int porder = sc.nextInt();
				sc.nextLine();
				
				switch(porder) {
				case 1:		// 추천글 순서로 보기
					ArrayList<Post> listpg = daop.postListGood();
					System.out.println("------------------------------------------------------------");
					System.out.println(" 글번호 | 1. 제목 | 2. 작성자 | 3. 작성일시 | 4. 추천수 | 5. 조회수");
					System.out.println("------------------------------------------------------------");
					
					// 글목록 출력하는 반복문
					for(int i = 0; i < listpg.size(); i++) {
						System.out.println(" " + listpg.get(i).getPnum() + " | 1. " + listpg.get(i).getTitle()
								+ " | 2. " + listpg.get(i).getName() + " | 3. " + listpg.get(i).getPdate()
								+ " | 4. " + listpg.get(i).getPgood() + " | 5. " + listpg.get(i).getPview());
					}// end for
					break;
				case 2:		// 최신 게시글 순으로 보기
					ArrayList<Post> listpv = daop.postListDate();
					System.out.println("------------------------------------------------------------");
					System.out.println(" 글번호 | 2. 제목 | 3. 작성자 | 4. 작성일시 | 5. 추천수 | 6. 조회수");
					System.out.println("------------------------------------------------------------");
					
					// 글목록 출력하는 반복문
					for(int i = 0; i < listpv.size(); i++) {
						System.out.println(" " + listpv.get(i).getPnum() + " | 1. " + listpv.get(i).getTitle()
								+ " | 2. " + listpv.get(i).getName() + " | 3. " + listpv.get(i).getPdate()
								+ " | 4. " + listpv.get(i).getPgood() + " | 5. " + listpv.get(i).getPview());
					}// end for
					break;
				default:
					break;
				}
				break;
			case 8:		// 게시글 검색
				System.out.println("1. 제목으로 검색");
				System.out.println("2. 작성자 이름으로 검색");
				System.out.print("검색 선택>> ");
				int psnum = sc.nextInt();	// post search number
				sc.nextLine();
				
				// 1번 인지 2번인지 고르는 switch문
				switch(psnum) {
				case 1:
					// 1. 제목으로 검색
					System.out.print("제목을 입력해 주세요>> ");
					String pst = sc.nextLine();
					ArrayList<Post> listps = daop.postListSearchTitle(pst);
					System.out.println("------------------------------------------------------------");
					System.out.println(" 글번호 | 1. 제목 | 2. 작성자 | 3. 작성일시 | 4. 추천수 | 5. 조회수");
					System.out.println("------------------------------------------------------------");
					
					// 글목록 출력하는 반복문
					for(int i = 0; i < listps.size(); i++) {
						System.out.println(" " + listps.get(i).getPnum() + " | 1. " + listps.get(i).getTitle()
								+ " | 2. " + listps.get(i).getName() + " | 3. " + listps.get(i).getPdate()
								+ " | 4. " + listps.get(i).getPgood() + " | 5. " + listps.get(i).getPview());
					}// end for
					break;
				case 2:
					// 2. 작성자 이름으로 검색
					System.out.print("작성자 이름을 입력해 주세요>> ");
					String psn = sc.nextLine();		// post search name
					ArrayList<Post> listpsn = daop.postListSearchName(psn);
					System.out.println("------------------------------------------------------------");
					System.out.println(" 글번호 | 1. 제목 | 2. 작성자 | 3. 작성일시 | 4. 추천수 | 5. 조회수");
					System.out.println("------------------------------------------------------------");
					
					// 글목록 출력하는 반복문
					for(int i = 0; i < listpsn.size(); i++) {
						System.out.println(" " + listpsn.get(i).getPnum() + " | 1. " + listpsn.get(i).getTitle()
								+ " | 2. " + listpsn.get(i).getName() + " | 3. " + listpsn.get(i).getPdate()
								+ " | 4. " + listpsn.get(i).getPgood() + " | 5. " + listpsn.get(i).getPview());
					}// end for
					break;
				default:
					break;
				}
				break;
				
				
			case 10:	// 회원가입
				System.out.println("회원가입입니다.");
				boolean runs = true;
				String nid = "";
				while(runs) {					
					// 아이디 입력
					System.out.print("아이디 입력 : ");
					nid = sc.nextLine();
					
					// 아이디 중복 확인
					if(dao.loginId(nid)) {
						System.out.println("이미 존재하고 있는 아이디 입니다.\n다른아이디를 입력해주세요.");
						
					} else {
						runs = false;
					}
				}
				
				// 비번, 이름 입력
				System.out.print("비밀번호 입력 : ");
				String npwd = sc.nextLine();
				System.out.print("이름 입력 : ");
				String nname = sc.nextLine();	
				
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
					System.out.printf("이름 : %s\n", list.get(0).getName());
				}				
				break;
			case 12:
				id = "";
				pwd = "";
				name = "";
				System.out.println("로그아웃 되었습니다.");
				break;
				
			default:	// 종료 기능
				System.out.println("종료되었습니다.");
				run = false;
			}//end switch
		}//end while				
	}//end main

}//end class
