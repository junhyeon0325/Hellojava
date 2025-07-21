package 장준현;

public class Report7 {

	public static void main(String[] args) {
		// 3, 6, 9 게임
		 
		int num = 700;	// 1 ~ 50 까지의 숫자
		String result = "";	// 숫자 및 하트가 출력되는 문자열

		// 1 ~ 50까지 찍어내는 반복 for문
		for(int i = 1; i <= num; i++) {
			int count = 0;	// 1의 자리수가 3의배수이거나 10의 자리수가 3, 6, 9 숫자가 들어가면은 count 1증가		
			int one = i % 10;	// 1의 자리수가 3의 배수인지 확인하는 변수 선언
			int tenmoc = i / 10;	// 10의 자리수 3, 6, 9 숫자가 들어가는지 확인하는 변수 선언
			int ten = tenmoc % 10; 
			int ohmoc = tenmoc / 10;
			int oh = ohmoc % 10;
			
			// 1의자리수, 10의자리수에서 3의 배수이면 count 1증가하는 if문
			if(one == 3 || one == 6 || one == 9) {	
				count++;	// 1의 자리수가 3의 배수이면은 count 1증가
			}
			if(ten == 3 || ten == 6 || ten == 9) {	 
				count++;	// 10의 자리수가 3, 6, 9이면은 count 1증가
			}
			if(oh == 3 || oh == 6 || oh == 9) {
				count++;	// 100의 자리수
			}
			
			// 앞서 count수에 의해서 출력되는 값 입력 > 3가지 count가 0인경우, count가 1인경우, count가 2인경우
			switch(count) {
			case 0 :	// case가 0인경우는 3의배수가 아니라는의미이니 그냥 숫자를 찍어냄 > 누적해서 result에 넣어야함
				result += i;
				break;
			case 1 :	// case가 1인경우는 3의배수가 한번 해당하는거니까 하트 한개 > 누적해서 result에 넣어야함
				result += "♥";
				break;
			case 2 :	// case가 2인 경우는 3의배수가 두번 해당하는거니까 하트 두개 > 누적해서 result에 넣어야함
				result += "♥♥";
				break;
			case 3 :
				result += "♥♥♥";
				break;
			}// end switch
			
			result += "\t";	// switch문에서 나온 하트 및 숫자 뒤에 탭 추가 > 일정한 간격을 보여주기위해
			if(one == 0) { result += "\n"; }	// 만약에 one변수가 0인경우는 0, 10, 20... 인경우니까 이때 한줄 띄우기 실행
		}// end for
		
		// 결과값 출력
		System.out.print(result);
		
	
	}// end main
}// end class
