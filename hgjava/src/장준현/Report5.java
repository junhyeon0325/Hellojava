package 장준현;

import java.util.Scanner;

public class Report5 {

	public static void main(String[] args) {
		// 섭씨-화씨 온도 변환 프로그램
		Scanner sc = new Scanner(System.in);
				
		boolean run = true;
		double hwa;
		double sub;
		
		while(run) {
			System.out.println("--------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("--------------------");
			System.out.print("번호 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch (num) {
			case 1 :
				System.out.print("화씨 온도 입력 : ");
				hwa = Integer.parseInt(sc.nextLine());
				sub = (5d / 9 * (hwa - 32));				
				System.out.println("섭씨온도 = " + sub);
				break;
			case 2 :
				System.out.print("섭씨 온도 입력 : ");
				sub = Integer.parseInt(sc.nextLine());
				hwa = (9d / 5 * sub + 32);
				System.out.println("섭씨온도 = " + hwa);
				break;
			default :
				System.out.println("program end");
				run = false;
			}
		}
		sc.close();
	}
}

