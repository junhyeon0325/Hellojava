package 장준현;

import java.util.Scanner;

public class Report3 {

	public static void main(String[] args) {
		// 숫자추측게임
		Scanner scanner = new Scanner(System.in);
		
		int randomnum = (int)(Math.random() * 100) + 1;
		int num = 0;
	
		
		while(randomnum != num) {
			System.out.print("숫자 입력 : ");
			num = Integer.parseInt(scanner.nextLine());
			
			if(randomnum > num) {
				System.out.println("up하세요!!");
			} else if(randomnum < num){
				System.out.println("down하세요!!");
			} else {
				System.out.println("축하합니다!!");
			}
		}
		scanner.close();		
	}

}
