package chap05;

import java.util.Scanner;

public class Ex223 {

	public static void main(String[] args) {
		// p223 문제6
		// switch문 이용
			
			
			
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			switch(selectNo) {
			case 1:		// 1.학생수 받아서 => 배열의 크기를 잡아줌
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
				break;
			case 2:		// 2.배열의 크기만큼 학생 점수 입력 받아 줌
				for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
				break;
			case 3:		// 3.배열에 저장된 학생 점수 출력해 줌
				for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
				break;
			case 4:		// 4.점수 중 최고점수와 평균점수 계산해서 출력해 줌
				int max = 0;
				int sum = 0;
				double avg = 0;
				for(int i = 0; i < studentNum; i++) {
					sum += scores[i];
					if(max < scores[i]) max = scores[i];
				}
				avg = (double)(sum) / studentNum;
				System.out.printf("최고 점수 : %d\n", max);
				System.out.print("평균 점수 : " + avg);
				System.out.println();
				break;
			default:	// 5.프로그램 종료
				run = false;				
			}
		}
		System.out.println("프로그램종료");

	}//end main

}// end class
