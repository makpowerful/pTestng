package practiceTestng.pTestng;

public class testExceptionPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3};
		
		for(int i=0; i<=a.length;i++) {
			try {
			System.out.println(a[i]);
			}
			catch(Exception ArrayIndexOutOfBoundsException) {
				System.out.println("Exception handled");
			}
		}
		
	}

}
