package JUnit_Test;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ClaseTestTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	
    @Before public void initialize() {
		ClaseTest test= new ClaseTest();
     }

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void TestAddNumber() {

		int a=9;
		int b=11;
		

		int result=a+b;
		assertEquals(20,result);
	}
	
	@Test
	public void TestAddString() {
		ClaseTest test= new ClaseTest();

		String c="Hello ";
		String e="World!";
		
		String result=test.addString(c, e);

		assertEquals("Hello World!",result);
		
	}
	
	@Test
	public void testSubtract() {
		long result= 100-12-(-6)-4;
		assertEquals(result,ClaseTest.subtract(100,12,-6,4));
		result=0;
		assertEquals(result,ClaseTest.subtract(0,0,0,0));
	}
	
	@Test
	public void testAdd() {
		long result= 3+4+5+2;
		assertEquals(result,ClaseTest.add(3,4,5,2));
		result=12;
		assertEquals(result,ClaseTest.add(5,6,1));
	}
	
	@Test
	public void testClaseAssertArrayEquals() {

		int[] numbers= {1,9,5,8,7};
		int[] expected= {1,5,7,8,9};
		ClaseTest.ClaseAssertArrayEquals(numbers);
		
		assertArrayEquals(numbers,expected);
	}



}
