package 장준현;

public class Report4 {

	public static void main(String[] args) {
		// 구구단 프로그램
		for(int i = 2; i <= 9; i++) {
			System.out.printf("%2d단    ",i);
		}
		System.out.println();
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%dx%d=%2d ", j, i, i*j);
			}
			System.out.println();
		}
	}
}
