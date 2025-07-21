package chap04;



public class Ex182 {

	public static void main(String[] args) {
		// p182 문제2
		// 1에서 100까지 정수 중 3의 배수 합, 3의 배수의 갯수
		int sum = 0;
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
				count++;
			}
		}
		System.out.println("3의 배수 합 : " + sum);
		System.out.println("3의 배수의 갯수 : " + count);
		
		// p183 문제3
		// 추가 : 몇 번만에 탈출했는지
		// 횟수 체크 변수 선언
		int count1 = 0;
		int dice1 = 0; 
		int dice2 = 0;
		
		// 반복문
			// 주사위2개 생성
			// 순서쌍 출력
			// 합이 5가 되었는 지 체크
			// 5면 탈출, 아니면 반복
		while(dice1 + dice2 != 5) {		
			dice1 = (int)(Math.random()*6)+1;
			dice2 = (int)(Math.random()*6)+1;
			System.out.printf("(%d, %d)\n",dice1, dice2);
			count1++;
		}		
		System.out.printf("%d번만에 탈출했음", count1);
		
		// p183 문제4
		// 조건 : 0 < x <= 10, 0 < y <= 10
		// 4 * x + 5 * y = 60 이 되는 (x,y)
		
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				int result = 4 * x + 5 * y;
				if(result == 60) {
					System.out.printf("(%d,%d)\n", x, y);
				}
			}
		}
		
		// p183 문제6
		for(int i = 1; i <= 4; i++) {
			for(int j = 3; j >= i; j--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
		System.out.println();
		}
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 4; j >= 1; j-- ) {
				if(j > i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		

	}//end main

}//end class
