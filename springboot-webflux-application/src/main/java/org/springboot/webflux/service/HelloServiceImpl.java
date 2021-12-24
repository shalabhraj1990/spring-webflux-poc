package org.springboot.webflux.service;

import java.time.Duration;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public Mono<String> sayHello() {
		return Mono.delay(Duration.ofSeconds(10)).then(Mono.just("Hello from SpringBoot Webfux"));
	}

}
