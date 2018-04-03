package JUnit_Test;

import java.util.Arrays;

public class ClaseTest {
	
	public ClaseTest(){};
	public int addNumber(int a,int b) {
		return a+b;
	}
	public String addString(String c,String e) {
		return c+e;
	}
	
	public static long subtract(long ... operands) {
		long ret=operands[0];
		for(int aa=1;aa<operands.length;aa++) {
			ret -= operands[aa];
		}
		return ret;
	}
	
	public static long add(long ... operands) {
		long ret=operands[0];
		for(int aa=1;aa<operands.length;aa++) {
			ret+=operands[aa];
		}
		return ret;
	}
	
	public static int[] ClaseAssertArrayEquals(int[] expected) {
		Arrays.sort(expected);
		return expected;
		
	}
}
