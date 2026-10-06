package practiceTestng.pTestng;

import java.util.*;

public class practicetestScanner {
	
	static int addition(int a, int b) {
		return a+b;
	}
	
	static int subtraction(int a, int b) {
		return a-b;
	}
	
	static int multiplication(int a, int b) {
		return a*b;
	}
	
	static int division(int a, int b) {
		return a/b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int num1 = sc.nextInt();
		System.out.println("Enter the second number: ");
		int num2 = sc.nextInt();
		
		int add = addition(num1,num2);
		int sub = subtraction(num1,num2);
		int mul = multiplication(num1,num2);
		int div = division(num1,num2);
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		

	}

}
