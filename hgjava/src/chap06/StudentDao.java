package chap06;

public class StudentDao {
	// 학생데이터 생성
	// 필드			
	// 생성자: 기본생성자 => 컴파일 자동 생성
	// 메소드
	Student[] stData(){
		Student[] students = {
				new Student("홍길동", 100, 100, 100),
				new Student("강길동", 90, 90, 90),
				new Student("이길동", 100, 50, 100),
				new Student("황길동", 100, 40, 100),
				new Student("고길동", 70, 100, 100),
				new Student("성춘향", 100, 100, 100),
				new Student("강춘향", 60, 50, 50),
				new Student("사골향", 70, 50, 77),
				new Student("레몬향", 88, 40, 84),
				new Student("멜론", 90, 74, 55)		
		};
	return students;
	}
}
