package chap05;

public class ExamArr {

	public static void main(String[] args) {
		// 배열 과제1
//		1. 배열에 저장 된 값들의 합, 최대값, 최소값 구하기 
		
		// array배열 생성
		int[] array = new int[10];
		
		//① 배열 값 : 1에서 100까지의 난수(Math.random()) 10개 배열에 저장 
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*100) + 1;
		//② 배열 값 출력 			
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		// 배열 값의 합계, 최대값, 최소값의 변수 설정
		int max = 1;
		int min = array[0];
		int sum = array[0];
		
//		③ 배열 값의 합계, 최대값, 최소값 출력 
		for(int i = 0; i < array.length; i++) {
			sum += array[i];	// 배열 값의 합계

			if(max < array[i]) {
				max = array[i];	// array[i]값이 max보다 클경우 array[i]를 max에 대입
			} 
			
			if(min > array[i]){
				min = array[i];	// array[i]가 min보다 작을경우 array[i]를 min에 대입 
			}
		}
		System.out.println("배열 값의 합계 : " + sum);
		System.out.println("배열 값의 최대값 : " + max);
		System.out.println("배열 값의 최소값 : " + min);
		
		// 배열의 요소 중 4의 배수 출력
		// 4의 배수 갯수 출력
		
		int count = 0;	// 4의 배수 갯수 새는 변수 설정
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 4 == 0) {
				System.out.print(array[i] + " ");
				count++;				
			}
		}
		System.out.println("\n4의 배수 갯수 : " + count);
		
		// 2차원 배열
		// 배열 선언
		int[][] twoArr = {
				{80, 90},
				{70, 60, 50}
		};
		// 2차원 출력
		for(int i = 0; i < twoArr.length; i++) {
			for(int j = 0; j < twoArr[i].length; j++) {
				System.out.printf("| %d ",twoArr[i][j]);
			}
			System.out.println();
		}
		
		
		
		// 과제2
//		2. 2차원 배열 출력 
//		• 배열= {{1,2,3}, {1,2}, {1}, {1,2,3}};
		// 2차원 배열 지정
		int[][] twoArr1 = {
				{1, 2, 3},
				{1, 2},
				{1},
				{1, 2, 3}
		};
		
		// twoArr1의 배열 출력
		for(int i = 0; i < twoArr1.length; i++) {
			for(int j = 0; j < twoArr1[i].length; j++) {
				System.out.printf("%d ", twoArr1[i][j]);
			}
			System.out.println();
		}
		
		
		
		// 과제3
//		3. 현재 관객의 수 출력 

		
		int[][] twoArr2 = new int[3][10];	//• 극장의 자리는 1줄에 10좌석씩 3줄
		int sum1 = 0;
		for(int i = 0; i < twoArr2.length; i++) {
			for(int j = 0; j < twoArr2[i].length; j++) {
				twoArr2[i][j] = (int)(Math.random()*2);		//• 관객이 있는 좌석은 1, 없는 좌석은 0 : 난수 이용
				System.out.printf("| %d ",twoArr2[i][j]);   //① 3행 10열의 배열에 0 또는 1 저장 -> 값 출력 

				sum1 += twoArr2[i][j];
			}
			System.out.println();
		}
//		② 관객 수 계산하기 -> 현재 관객 수는 00명
		System.out.printf("관객 수 : %d\n", sum1);
		
		
		
		// 과제4
//		4. 학생 별 평균 계산하기 
//		• 학생 3명, 각 학생당 5번의 테스트 점수를 배열에 저장
		int[][] student = new int[3][5];
		for(int i = 0; i < student.length; i++) {
			for(int j = 0; j < student[i].length; j++) {
//		• 50 <= 점수 <= 100 
				student[i][j] = (int)(Math.random() * 51) + 50;
				System.out.printf("%d ", student[i][j]);
			}
			System.out.println();
		}				
		
//		• 학생 별 평균 계산 출력
		for(int i = 0; i < student.length; i++) {
			double avg = 0;
			double sum2 = 0;
			for(int j = 0; j <student[i].length; j++) {
				sum2 += student[i][j];
			}
			avg = sum2 / 5;
			System.out.printf("%d번 학생 평균 : %.2f\n", i+1, avg);				
		}
		
		
		
		//5. 카드를 랜덤하게 선택하여 화면에 출력 
//		• 배열 : {"Clubs", "Diamonds", "Hearts", "Spades"}  
//		• 배열 : {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"} 
		String[] cardname = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] cardnumber = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
//		• 각 카드를 랜덤하게 선택하는 코드 작성(5번)
		for(int k = 1; k < 6; k++) {
			int i = (int)(Math.random() * 4); 
			int j = (int)(Math.random() * 13);
			System.out.printf("%s의 %s\n",cardname[i],cardnumber[j]);			
		}
		
		
		
//		6. 2차원 배열 만들기 
//		• 3*5 크기의 2차원 배열 생성하고 초기값은 0으로 초기화 
//		• 5개의 정수 1을 랜덤하게 배치 
//		• 최종 배열 출력
		int[][] num = new int[3][5];
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				
			}
		}
	}// end main

}// end class
