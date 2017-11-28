package qa.consulting.com.Automated_testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyClass {

	@BeforeClass
	public static void init() {
		System.out.println("init");
	}
	@Before
	public void setUp() {
		System.out.println("set up");
	}
	
	@Test
	public void test1() {
		System.out.println("Hello world");
	}
	
	@After
	public void tearDown() {
		System.out.println("After");
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("destroy");
	}
}
