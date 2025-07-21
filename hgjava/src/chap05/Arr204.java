package chap05;

public class Arr204 {

	public static void main(String[] args) {
		//  배열 생성, 배열데이터 활용
		// p204 예제
		// add메소드 없이 그냥 바로생성하고 바로 합해서 출력
		int[] scores;	// int형 배열 생성 이름은 scores
		scores = new int[] {83, 90, 87};	// scores배열에 데이터삽입
		int sum1 = 0;	// sum1 변수 초기화
		for(int i = 0; i < 3; i++) {	// for문을 이용해서 하나하나 더하기
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);		// sum1출력
		
		
		// add메소드를 이용해서 출력
		int sum2 = add(new int[] {83, 90, 87});		// 
		System.out.println("총합 : " + sum2);
		System.out.println();
		
		
		
		// 교수님이 내주신 문제
		// int형의 배열 선언 , 크기 : 5
		int[] a = new int[5];
		
		// 배열에 50~100 사이의 수 5개 입력
		for( int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*51) + 50;
			System.out.println(a[i]);
		}
		
		// 배열의 합 계산
		int sum3 = add(a);
		System.out.println(sum3);
		
	}// end main

	public static int add(int[] scores) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		
		return sum;
	}// end add
	
	
	
	

}// end class
