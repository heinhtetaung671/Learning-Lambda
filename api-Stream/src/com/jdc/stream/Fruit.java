package com.jdc.stream;

public class Fruit {
	
	private String name;
	private String colour;
	private int weight;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Fruit(String line) {
		String[]arr  = line.split(",");
		name = arr[0].trim();
		colour = arr[1].trim();
		weight = Integer.parseInt((arr[2]).trim());
		
	}
	
}
