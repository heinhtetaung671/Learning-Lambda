package com.jdc.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class StreamApp {

	static Stream<Fruit> convertFronFile() throws IOException{
		return Files.lines(new File("Fruit.txt").toPath()).map(Fruit::new);
	}
	
	
	public static void main(String[] args) throws IOException {
		var result = convertFronFile().mapToDouble(fruit -> fruit.getWeight()).summaryStatistics();
		
//		result.ifPresentOrElse(d -> System.out.println("Average weight of Fruits is : %fg".formatted(d)), () -> System.out.println("No Fruits avaliable!"));
		
		var obj = convertFronFile().filter(fruit -> fruit.getColour().equals("Red")).count();
		
		System.out.println("count is : "+obj);
		
		
		
	}
}
