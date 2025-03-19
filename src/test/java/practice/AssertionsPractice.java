package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample() 
	{
		System.out.println("step 1");
		Assert.assertEquals(1, 1);
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		System.out.println("step 5");
     }
	
	@Test
	public void sample1()
	{
	    SoftAssert sa= new SoftAssert();
	    
	    System.out.println("step 1");
	    sa.assertEquals(1, 2);
	    System.out.println("step 2");
	    System.out.println("step 3");
	    sa.assertEquals("a", "b");
	    System.out.println("step 4");
	    System.out.println("step 5");
	    
	    sa.assertAll();
		
	}

}
