package 장준현;

import java.util.Scanner;

public class Report1 {

	public static void main(String[] args) {
		// 윤년 계산 프로그램
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("##년도 입력 : ");
		int year = Integer.parseInt(scanner.nextLine());
		
		
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0 )) {
			System.out.printf("%d년은 윤년입니다.\n",year);			
		} else {
			System.out.printf("%d년은 평년입니다.\n",year);			
		}
		
		scanner.close();
		
	}

}
