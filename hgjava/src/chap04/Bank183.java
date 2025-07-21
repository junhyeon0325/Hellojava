package chap04;

import java.util.Scanner;

public class Bank183 {

	public static void main(String[] args) {
		// 은행업무
		// 잔고 변수 생성
		// 실행제어 변수
		// 업무1:예금, 2:출금, 3:조회, 4:종료
		// 종료가 될 때까지 반복
		// p183 문제7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		int money;
				
		while(run) {
			System.out.println("------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------");
			System.out.print("선택> ");
			
			int selNum = Integer.parseInt(scanner.nextLine());
			
			switch(selNum) {
			case 1 :
				System.out.print("예금액>");
				money = Integer.parseInt(scanner.nextLine());
				balance += money;
				break;
			case 2 :
				System.out.print("출금액>");
				money = Integer.parseInt(scanner.nextLine());
				if(money > balance) {
					System.out.println("잔액 부족");
					System.out.printf("출금가능액 : %d\n", balance);
				} else {
					balance -= money;
				}
				break;
			case 3 :
				System.out.printf("잔고>%d\n",balance);
				break;
			default :
				run = false;				
			}		
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
