package locators;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class streamFilter {
//	@Test
//	public void regular() {
//		ArrayList<String> names =new ArrayList<String>();
//		names.add("Black");
//		names.add("Adam");
//		names.add("Sofie");
//		names.add("Annie");
//		names.add("Osprey");
//		
//		int count = 0;
//		
//		for(int i=0 ; i<names.size() ; i++)
//		{
//			String actual = names.get(i);
//			if(actual.contains("A"))
//			{
//			count++;
//			}
//		}
//		System.out.println(count);
//	}
	@Test
	public void streamFilter() {
		ArrayList<String> names =new ArrayList<String>();
		names.add("Black");
		names.add("Adam");
		names.add("Sofie");
		names.add("Annie");
		names.add("Osprey");
		
		Long c = names.stream().filter(n->n.startsWith("A")).count(); //datatype od count here is Long
		System.out.println(c);
		
	}
	
	
	

}
