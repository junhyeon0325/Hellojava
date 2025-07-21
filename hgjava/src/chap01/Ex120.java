package chap01;

import java.util.Scanner;

public class Ex120 {

	public static void main(String[] args) {
		// p120 문제1
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %s-%s-%s\n", tel1, tel2, tel3);
		
		// p121 문제2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수1 입력>");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("수2 입력>");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = num1 + num2;
		System.out.println("덧셈 결과:" + result);
		
		sc.close();
		
		
		
	}// end main

}// end class
