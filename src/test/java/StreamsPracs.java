package test.java;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class StreamsPracs {

	@Test
	public void arrStr() {
		ArrayList<String> str = new ArrayList<String>();
		str.add("Rohan");
		str.add("Tejas");
		str.add("Roshin");
		str.add("Bala");
		
		Long c = str.stream().filter(s->s.startsWith("R")).count();
		System.out.println(c);
		
		
		str.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	
	
}
		