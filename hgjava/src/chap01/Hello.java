package chap01;

public class Hello {

	public static void main(String[] args) {
		// 출력문
		System.out.println("hello java!!!");
		int a = 7;
		System.out.println(a);
		
		// 변수 값 교환
		int x = 10;
		int y = 50;
		int temp = y;
		y = x;
		x = temp;
		System.out.println("x=" + x + ", y=" + y);
		
		// 기본타입
		char font = 'A';
		int intchar = font + 1;
		char font2 = (char)intchar;
		System.out.println(font);
		System.out.print(intchar + "\n");
		System.out.println(font2);
		
		// 문자열 저장 -> String 객체타입 변수 생성
		String str = "홍길동";
		System.out.println(str);
		
		// 연산 : 정수 => 기본타입 int, 실수 => 기본타입 double
		int su1 = 1;
		int su2 = 3;
//		int result = su1 / su2;
		double result = su1 / su2; // int / int = int
		
		// 결과 = 0.3333...
		result = (double)su1 / su2;
		System.out.println(result);
		
		String str1 = "신용권";
		String str2 = "신용권";
		String str3 = new String("신용권");
		boolean resultStr = str1 == str2;
		boolean resultobj = str2 == str3;
		System.out.println(resultStr);
		System.out.println(resultobj);
		System.out.println(str1.equals(str3));
		
		// &=, |=, ^= 연산
		int r1 = 1 & 2;	
		int r2 = 1 | 2;
		int r3 = 1 ^ 2;
		System.out.println("and 연산 = " + r1);
		System.out.println("or 연산 = " + r2);
		System.out.println("xor 연산 = " + r3);
		
		// 수 20의 4배수이면서 5의 배수인지 체크 if
		// 결과 = 20은 4의 5의 배수입니다 출력 printf
		// 아니면 20은 4의 5의 배수가 아닙니다 출력 printf
		int su = 20;
		if ((su % 4 == 0) && (su % 5 == 0)) {
			System.out.printf("%d는 4의 5의 배수입니다.\n", su);
		} else {
			System.out.printf("%d은 4의 5의 배수가 아닙니다.\n", su);			
		}
		
		// 홀수 짝수 구별 (삼항연산자)
		// 수는 20을 이용
		String result12 = su % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result12);
	}

}
