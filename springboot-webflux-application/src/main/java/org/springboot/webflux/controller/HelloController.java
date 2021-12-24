package org.springboot.webflux.controller;

import org.springboot.webflux.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {
	@Autowired
	HelloService helloService;

	@GetMapping("hi")
	public Mono<String> sayHellow() {
		return helloService.sayHello();
	}

}
