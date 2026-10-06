package practiceTestng.pTestng;
import java.util.*;

public class testSampleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Object> ll = new LinkedList<Object>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		
		System.out.println(ll.get(0));
		System.out.println(ll.peek());
		System.out.println(ll.peekFirst());
		System.out.println(ll.peekLast());
	}

}
