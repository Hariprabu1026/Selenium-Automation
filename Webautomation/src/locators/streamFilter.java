package locators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class streamFilter {
	@Test
	public void regular() {
		ArrayList<String> names =new ArrayList<String>();
		names.add("Black");
		names.add("Adam");
		names.add("Sofie");
		names.add("Annie");
		names.add("Osprey");
		
		int count = 0;
		
		for(int i=0 ; i<names.size() ; i++)
		{
			String actual = names.get(i);
			if(actual.contains("A"))
			{
			count++;
			}
		}
		System.out.println(count);
	}
	@Test
	public void streamFilter() {
		ArrayList<String> names =new ArrayList<String>();
		names.add("Black");
		names.add("Adam");
		names.add("Sofie");
		names.add("Annie");
		names.add("Osprey");
		
		Long c = names.stream().filter(n->n.startsWith("A")).count(); //data type of count here is Long
		System.out.println(c);
		
		long d = Stream.of("Chester","Copier","Smith","Goldenway","Licious").filter(s->
		{
			s.startsWith("G");
			return true;
		}).count();

		//print all the names in ArrayList
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
	}

	@Test
	public void streamMap() {
		Stream.of("Chester","Copier","Smith","Goldenway","Licious").filter(s->s.endsWith("r")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamSort()
	{
		List<String> names = Arrays.asList("Genfield","Fortuner","Vento","Polo","Venue","Creta");
		names.stream().filter(s->s.startsWith("V")).sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		
	}
	

}
