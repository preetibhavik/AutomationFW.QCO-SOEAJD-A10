package practice;

import genericUtilities.JavaUtility;

public class GenericMethodsPractice {

	public static void main(String[] args) {
	//hardcoding
		//int a=30;
		//int b=40;
		//int c=a+b;
		//System.out.println(c);
		
	//call add here	
	int sum = add(20,30);
	System.out.println(sum);
	int v =add(sum,50);
	System.out.println(v);
	System.out.println(add(200,500));
	
	JavaUtility j = new JavaUtility();
	System.out.println(j.getSystemDateInFormat());

	}
	public static int add(int a, int b)
	{
	int c= a+b;
	return c;
	
	}

}
