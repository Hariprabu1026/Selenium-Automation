package testNG_xml_Leaning;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@Test
	public void ZTest01()
	{
		System.out.println("Z method execution");
	}
	
	@BeforeMethod
	public void beforeTest01()
	{
		System.out.println("Im Before Test");
	}
	
	@Test
	public void GTest02()
	{
		System.out.println("G Method execution");
	}
	
	@Test
	public void BTest03()
	{
		System.out.println("B method execution");
	}

}
