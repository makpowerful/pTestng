package practiceTestng.pTestng;

//1 main , 2 cons, 3 sib, 3 iib , 2 static, 4 non static

public class praticeMixedProgram {
	
	
	praticeMixedProgram(){
		System.out.println("first constructor");
	}
	
	praticeMixedProgram(int a){
		System.out.println("second constructor");
	}
	
	static {System.out.println("sib 1");}
	static {System.out.println("sib 2");}
	static {System.out.println("sib 3");}
	
	{System.out.println("iib 1");}
	{System.out.println("iib 2");}
	{System.out.println("iib 3");}
	
	public static void one(){
		System.out.println("static menthod 1");
	}
	
	public static void two(){
		System.out.println("static menthod 2");
	}
	
	public void nonstatic1() {
		System.out.println("non-static menthod 1");
	}
	public void nonstatic2() {
		System.out.println("non-static menthod 2");
	}
	public void nonstatic3() {
		System.out.println("non-static menthod 3");
	}
	public void nonstatic4() {
		System.out.println("non-static menthod 4");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		praticeMixedProgram mp = new praticeMixedProgram();
		praticeMixedProgram mp1 = new praticeMixedProgram(2);
		
		mp1.nonstatic1();
		mp.nonstatic2();
		one();
		two();
	}

}
