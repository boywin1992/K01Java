package ex15usefulclass;
 
/*
Object 클래스
-자바에서의 최상의 클래스
-별도의 선언없이 Object에 정의된 모든 메소드를
	사용할 수 있다.
-개발자가 정의한 모든 클래스를 Object의 인스턴스로
	참조할 수 있다.
	Ex) Object obj = new Person()
		혹은
		void myFunc(Object obj){}
 */
class myFriends extends Object {
	String myName;
	public myFriends(String name) {
		myName = name;
	}	
	
	@Override
	public String toString() {
		return "이름:"+ myName;
	}
} 
/*
toString() 메소드
- Object 클래스에 정의된 메소드로 println()이 문자열을
	출력하기전에 자동으로 호출하는 메소드이다
- 인스턴스 변수를 문자열 형태로 변환하여 반환한다
- 필요한 경우 클래스 정의시 오버라이딩하여 재정의 하는것이
	좋다. 단, 필수사항은 아니다. 
 */
class yourFriends extends Object {
	
	String myName;
	public yourFriends(String name) {
		myName = name;
	}	
}

public class E04Object1toString {

	public static void main(String[] args) {

		myFriends fnd1 = new myFriends("성유겸");
		yourFriends fnd2 = new yourFriends("헬로비너스");
 
		System.out.println(fnd1); 
		System.out.println(fnd2); 	
	}
}
