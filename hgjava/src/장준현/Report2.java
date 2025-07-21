package 장준현;

import java.util.Scanner;

public class Report2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 동전 교환 프로그램
		Scanner scanner = new Scanner(System.in);
		System.out.print("##교환할 금액 : ");
		int money = Integer.parseInt(scanner.nextLine());
		int count500 = 0;
		int count100 = 0;
		int count50 = 0;
		int count10 = 0;
		
		count500 = money / 500;
		money -= (count500 * 500);
		System.out.printf("500원 짜리 : %d개\n", count500);
		
		count100 = money / 100;
		money -= (count100 * 100);
		System.out.printf("100원 짜리 : %d개\n", count100);
		
		count50 = money / 50;
		money -= (count50 * 50);
		System.out.printf("50원  짜리 : %d개\n", count50);
		
		count10 = money / 10;
		money -= (count10 * 10);
		System.out.printf("10원  짜리 : %d개\n", count10);

		int change = (count500 * 500) + (count100 * 100) + (count50 * 50) + (count10 * 10);
		System.out.printf("교환  금액 : %d원\n", change);
		System.out.printf("남은  금액 : %d원\n", money);	
		
		scanner.close();
	}

}

