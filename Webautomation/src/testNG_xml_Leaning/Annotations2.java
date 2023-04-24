package testNG_xml_Leaning;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations2 {
	
	@Test
	public void ZTest01()
	{
		System.out.println("Annotation 2 C method");
	}
	
	@BeforeMethod
	public void beforeTest01()
	{
		System.out.println("Annotation 2 BeforeMethod");
	}
	
	@Test
	public void GTest02()
	{
		System.out.println("Annotation 2 L method");
	}
	
	@Test
	public void BTest03()
	{
		System.out.println("Annotation 2 V method");
	}

}
