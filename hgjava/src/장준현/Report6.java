package 장준현;

import java.util.Scanner;

public class Report6 {

	public static void main(String[] args) {
		// 가위,바위,보 게임 프로그램
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int man = 0;
				
//		// 결과값 출력
//		System.out.printf("사람 %d, 컴 %d %s", man, com);
		
		while(run) {
			// 컴 난수 생성
			int com = (int)(Math.random()*3);
			
			// 가위바위보 문장생성 및 숫자 입력
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			man = Integer.parseInt(sc.nextLine());
			
			int result = ((man - com) + 1) % 3;
			if(man > 2) {
				run = false;
			}else if(result % 3 == 1) {
				System.out.printf("사람 %d, 컴 %d 비겼음\n", man, com);
			} else if(result % 3 == 0) {
				System.out.printf("사람 %d, 컴 %d 컴 승리\n", man, com);
			} else {
				System.out.printf("사람 %d, 컴 %d 사람 승리\n", man, com);
			}
			
//			비기는경우
//			00 0 1
//			11 0 1
//			22 0 1
//			
//			이기는경우
//			02 -2 -1
//			10 1 2
//			21 1 2
//			
//			지는 경우
//			01 -1 0
//			12 -1 0
//			20 2 3
								
		}
		System.out.println("game over");
		sc.close();
	}

}
