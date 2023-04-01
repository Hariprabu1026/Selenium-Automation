package locators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class streamFilter {
	/*
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
				if(actual.endsWith("m"))																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
				{
				System.out.println(actual);
				}
			}
		}
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

	@ Test
	public void streamMap() {
		Stream.of("Chester","Copier","Smith","Goldenway","Licious").filter(s->s.endsWith("r")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
	}
	*/
	/*@Test
	public void streamSort()
	{
		
		List<String> names = Arrays.asList("Genfield","Fortuner","Vento","Polo","Venue","Creta");
		names.stream().filter(s->s.startsWith("V")).sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		
		List<String> names1 = Arrays.asList("Powerstar","Superstar","Littlestar","Rajni","Simbu");
		
		//Merging two List and sorting
		Stream<String> newNames = Stream.concat(names.stream(), names1.stream());
		//newNames.sorted().forEach(s->System.out.println(s));
		
		//Filtering with anyMatch method to find the element 
		boolean flag = newNames.anyMatch(s->s.equalsIgnoreCase("Superstar"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	*/
	@Test
	public void streamCollect()
	{
		List<String> names = Stream.of("Tester","Developer","Analyst","Scrum","Agile").filter(s->s.contains("er"))
				.collect(Collectors.toList());
		System.out.println(names.get(0));
		
		
		List<Integer> numbers = Arrays.asList(4,5,6,3,6,9,1,8,3); //1,3,4,5,6,9
		//print unique number
		//sort
		//numbers.stream().sorted().distinct().forEach(s->System.out.println(s));
		List<Integer> li = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

}
