package org.springboot.webflux.service;

import reactor.core.publisher.Mono;

public interface HelloService {
	public Mono<String> sayHello();
}
