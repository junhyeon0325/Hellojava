package chap06;

public class StudentMain {

	public static void main(String[] args) {
		// 객체 생성 => 배열에 저장
		StudentDao stdao = new StudentDao();
		Student[] students = stdao.stData();
		
		// 객체 사용
		for(int i = 0; i < students.length; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\n",
					students[i].name,
					students[i].kor,
					students[i].eng,
					students[i].math,
					students[i].tot(),
					students[i].avg(),
					students[i].grade());					
		}
			
	}

}
