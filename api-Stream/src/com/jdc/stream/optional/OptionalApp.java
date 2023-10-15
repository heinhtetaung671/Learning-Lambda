package com.jdc.stream.optional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalApp {
	
	
	String  getcarInsuranceNameOptional(Optional<Person> person) {
		
		return person.filter(Objects::nonNull).map(Person::getCar).filter(Objects::nonNull).map(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
		
	}
	
	

	String getcarInsuranceName(Person person) {
		if(person == null) {
			return "Unknown";
			
		}
		
		var car = person.getCar();
		if(null == car) {
			return "Unknown";
		}
		
		var insurance = car.getInsurance();
		if(null == insurance) {
			return "Unknown";
		}
		
		return insurance.getName();
	}
	
}
