package JUnit_Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClaseTestTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

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
		ClaseTest test= new ClaseTest();
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
		
		String result=test.addString(c,e);
		assertEquals("Hello World!",result);
		
	}

}
