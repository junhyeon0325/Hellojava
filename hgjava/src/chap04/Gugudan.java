package chap04;

public class Gugudan {

	public static void main(String[] args) {
		// 구구단
		// 단 반복
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println("**** " + dan + "단 ****");
			for(int gob = 1; gob <= 9; gob++) {
				System.out.printf("%d x %d = %d\n", dan, gob, dan*gob);
			}
		}
		
		// 구구단 2
		for(int dan = 2; dan <= 9; dan++) {
			System.out.printf("%d단     ", dan);
		}
		System.out.println();
		for(int gob = 1; gob <= 9; gob++) {			
			for(int dan = 2; dan <= 9; dan++) {
				System.out.printf("%dx%d=%2d ",dan, gob, dan*gob);
			}
			System.out.println();
		}
		
		// 183p 5번
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		// 183 6번
		for(int i = 1; i <= 4; i++) {
			for(int j = 3; j >= i; j--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}// end main

}
