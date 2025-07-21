package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 게임
		// 주사위를 2개 던져서
		// 합이 10을 넘으면 두수를 더하고 > 덧셈결과 : 000
		// 아니면 두수를 곱한 결과를 출력 > 곱셈결과 : 000
		
		int num1 = (int)(Math.random() * 6) + 1;
		System.out.println("첫번째 주사위 : " + num1);
		int num2 = (int)(Math.random() * 6) + 1;
		System.out.println("두번째 주사위 : " + num2);
		
		int resultsum = num1 + num2;
		int resultgob = num1 * num2;
		
		if(resultsum > 10) {
			System.out.println("덧셈결과 : " + resultsum);			
		} else {
			System.out.println("곱셈결과 : " + resultgob);			
		}
		System.out.println();
		
		// 오전시간(9~12) 일정 출력
		// 현재 시간 확인
		int time = (int) (Math.random() * 4) + 9;
		System.out.println("현재시간 : " + time + "시");
		// 9시 : 출근합니다
		// 10시 : 회의합니다
		// 11시 : 업무를 봅니다
		// 12시 : 외근을 나갑니다		
		switch(time) {
		case 9:
			System.out.println("출근합니다.");
		case 10:
			System.out.println("회의합니다.");
		case 11:
			System.out.println("업무를 봅니다.");
		case 12:
			System.out.println("외근을 나갑니다.");
			break;
		}
		System.out.println("오늘 일정 끝");
		
		//p169 문제3 => switch문으로 변경
		int score = 85;
		
		System.out.print("등급은 ");		
		
		switch(score / 10) {
		case 10:
		case 9:
			System.out.print("A");
			break;
		case 8:
			System.out.print("B");
			break; 
		case 7:
			System.out.print("C");
			break;			
		default:
			System.out.print("D");
			break;				
		}
		System.out.println("입니다.");
		
		// 주사위 게임
		// 주사위 2개 던져서 합이 10이 되면 탈출
			// 주사위 순서쌍 출력(5,2)
		// 5회이상이 되면 게임오버 출력
		
		for(int i = 0; i < 5; i++) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			
			System.out.printf(" (%d,%d)\n",dice1 ,dice2);
			
			if(dice1 + dice2 > 10) {
				System.out.println("탈출성공");
				break;
			}			
		}
		System.out.println("게임오버");
	}

}
