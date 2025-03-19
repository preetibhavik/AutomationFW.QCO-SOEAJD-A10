package practice;

import org.testng.annotations.Test;

public class Priority_Invocation_Enabled {
	@Test(priority=2,invocationCount=2)
	public void demo1()
	{
		System.out.println("Hi demo1");
	}
	
    @Test(priority=1,invocationCount=4)
    public void demo2()
    {
    	System.out.println("Hi demo2");
    }
}
