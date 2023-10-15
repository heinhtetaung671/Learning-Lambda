package com.jdc.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperation {

	
	public static void main(String[] args) {
		var intList = List.of(1,2,3,4,5,6,7,8,9,10);
		flapMap();
		reduce(intList);
		var unorderList = List.of("Markyyy","Naomi","Kiboy","Albert","Kairi","Butss","Bloyski","Skylar");
		var orderList = List.of("A Phoo","Baby","Calara","Derek","Emily","Zack");
		
		// takeWhile is opposite dropWhile
		// takeWhile KA CONDITION MHR TR NAE YAT P (mhr tr nae sat ma lote bu nout mr hman lel) //
		// drop while KA THU CONDITION MHR TR NAE SA LOTE TL (mhr p so dr nae sa lote p nout ka hr ty ma kyi bu) //
		
		takeWhile(orderList);
		collect(unorderList);
		collectInt(intList);
		
		System.out.println(find(unorderList));
		
	}
	
	static Optional<String> find(List<String> list) {
		
		return list.stream().filter(s -> s.length()  > 5).findAny();
	}
	
	
	
	static void collect(List<String> list) {
		var sb = new StringBuilder();
		var result = list.stream().filter(s -> s.length() > 5).collect(Collectors.joining(", ", "MLBB PRO PLAYERS : ", "."));
		
		System.out.println(result);
	
	}
	
	static void collectInt(List<Integer> list) {
		
		var result = list.stream().collect(Collectors.partitioningBy(i -> i % 2 ==0));
		System.out.println(result);
		
	}
	
	
	static void takeWhile(List<String> list) {
		list.parallelStream().takeWhile(s -> s.length() > 5).forEachOrdered(System.out::println);
	}
	
	
	static void reduce(List<Integer> list) {
		var result = list.stream().reduce((a,b) -> a+b);
		result.filter(i -> i>0).ifPresentOrElse(a -> System.out.println("Resutl : " + a), () -> System.out.println("Something Wront!"));
	}
	
	
	
	static void flapMap() {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 2, 3));
		list.add(Arrays.asList(4,5,6));
		list.add((Arrays.asList(7,8,9,10)));
		
		list.stream().flatMap(l -> l.stream().map(i -> i)).filter(i -> i % 2 == 0 ).forEach(System.out::println);
		
		
	}
	
	
	static boolean isEven(int i) {
		return i % 2 ==0;
	}
	
}
