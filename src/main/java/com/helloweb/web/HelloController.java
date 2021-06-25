package com.helloweb.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/hellos")

public class HelloController {

	private List<String> names = new ArrayList<>();
	
	
	
	// basic 'get' mapping - no parameters
	@GetMapping("/")
	public String printHello() {
		return "Hello world";
	}
	
	
	// 'get' mapping accepting RequestParam
	@GetMapping("/get")
	public String printHello(@RequestParam String name) {
		if (name == null || name.equals("")) {
			name = "World";
		}

		return "Hello " +name+ "!";
	}
	
	// 'get' mapping accepting PathVariable
	@GetMapping("/get/{id}")
	public String printHello(@PathVariable int id) {

		return "Hello " +id+"!";
	}
	
	@GetMapping("/list")
	public List<String> listNames() {
		return names;
	}
	
	
	
	// post mapping add a name to the list
	@PostMapping("")
	public String addName(@RequestParam String name) {
		if (name!= null && !name.equals("")){
			names.add(name);
		}
		return name + " added!";
	}
	
	
}
