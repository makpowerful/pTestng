package practiceTestng.pTestng;

public class testLowernVerticalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "india";
		s = s.toUpperCase();
		String s2[] = s.split("");
		
		for(String s1 : s2) {
			System.out.println(s1);
		}
		
		boolean flag = true;
		
		char c[] = s.toCharArray();
		for(char cc : c) {
			if(!Character.isAlphabetic(cc)) {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println(flag);
		}
		else {
		System.out.println(flag);
		}
		

	}

}
