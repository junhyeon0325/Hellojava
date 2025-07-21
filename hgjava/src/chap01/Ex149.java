package chap01;

import java.util.Scanner;

public class Ex149 {

	public static void main(String[] args) {
		// p149 문제1
		// 이유 주석으로 표시, 오류 수정
		int b = 5; // 연산하면 정수형으로 연산하니까 int로
		b = -b;
		int result = 10 / b;
		System.out.println(result);
		
		// 문제2
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z); // z는 31
		
		// 문제3
		// 문제4
		int pencils = 534;
		int students = 30;
		
		//학생 1명이 가지는 연필 개수
		int pencilsPerStudent = (pencils / students);
		System.out.println(pencilsPerStudent);
		
		//남은 연필 개수
		int pencilsLeft = (pencils % students);
		System.out.println(pencilsLeft);
		
		// 문제5
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1 / var2; // 정수를 나누면 2.5에서 .5가빠지고 2가나오는데 그걸 더블에 넣으니까 3이아니라 2지
		int var4 = (int)(var3 * var2);
		System.out.println(var4);
		
		// 문제6 ?
		int value = 356;
		System.out.println((value/100)*100);
		
		// 문제7 설마 했는데 var22가 float형식이고 그냥0.1은 double형식이라 틀렸다고 뜬거임?
		float var11 = 10f;
		float var22 = var11 / 100;
		if(var22 == 0.1f) {
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		// 문제8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (double)((lengthTop + lengthBottom) * height) / 2;
		System.out.println(area);
		
		// 문제9
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 수: ");
		double num1 = Double.parseDouble(sc.nextLine());
		
		
		System.out.print("두 번째 수: ");
		double num2 = Double.parseDouble(sc.nextLine());
		
		System.out.println("--------------------");
		
		if(num2 == 0 || num2 == 0.0) {
			System.out.println("결과:무한대");
		} else {
			double result1 = num1 / num2;
			System.out.println("결과:" + result1);			
		}
		
//		sc.close();
		
		// 문제 10
		int var111 = 10;
		int var222 = 3;
		int var333 = 14;
		double var444 = var111 * var111 * Double.parseDouble(var222 + "." + var333); // 지금 여기서3.14를 만드는건 문자형식이니까 이걸 더블형식으로 바꿔줘야함
		System.out.println("원의 넓이:" + var444);
		
		// 문제 11
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디:");
		String name = scanner.nextLine();
		
		System.out.print("패스워드:");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
//		scanner.close();
		
		// 문제 12
		int i = 10;
		int j = 5;
		System.out.println( (i>7) && (j<=5));
		
		//교수님이 주신 문제
		//윤년 계산 프로그램
		String yy;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("##년도 입력 : ");
		int year = Integer.parseInt(scan.nextLine());
		
//		if(year % 4 == 0) {
//			if(year % 400 == 0) {
//				if(year % 100 == 0) {
//					yy = "평년";					
//				}
//				yy = "윤년";
//			}
//			yy = "윤년";
//		} else {
//			yy = "평년";
//		}
//		System.out.println(year + "년은 " + yy + "입니다.");
		
//		if(year % 4 == 0) {
//			if(year % 400 == 0 || year % 100 != 0) {
//				System.out.println(year + "년 윤년");
//			} else {
//				System.out.println(year + "년 평년");
//			}
//		} else {
//			System.out.println(year + "년 평년");
//		}
		
		if(year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
			System.out.println(year + "년 윤년");
		} else {
			System.out.println(year + "년 평년");
		}				
		
		scan.close();
		
	}// end main

}// end class
