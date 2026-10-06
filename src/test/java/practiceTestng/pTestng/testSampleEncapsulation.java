package practiceTestng.pTestng;

public class testSampleEncapsulation {
	
	private int a;
	private int b;
	
	testSampleEncapsulation(){
		this.a = 10;
		this.b = 20;
	}
	
	public void val() {
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		testSampleEncapsulation aa = new testSampleEncapsulation();
		aa.val();
	}
	

}
