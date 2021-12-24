package org.springboot.mvc.controller;

import org.springboot.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	HelloService helloService;

	@GetMapping("hi")
	public String sayHellow() {
		return helloService.sayHello();
	}

}
