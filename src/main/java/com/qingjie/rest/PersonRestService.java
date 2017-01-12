package com.qingjie.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestService {

	private static final List<Person> persons;

	static {
		persons = new ArrayList<>();
		persons.add(new Person("Qingjie", "Zhao"));
		persons.add(new Person("Qingtao", "Zhou"));
	}

	@RequestMapping(path = "/persons", method = RequestMethod.GET)
	public static List<Person> getPersons() {
		return persons;
	}

	@RequestMapping(path = "/persons/{name}", method = RequestMethod.GET)
	public static Person getPerson(@PathVariable("name") String name) {
		return persons.stream().filter(person -> name.equalsIgnoreCase(person.getName())).findAny().orElse(null);
	}

}
