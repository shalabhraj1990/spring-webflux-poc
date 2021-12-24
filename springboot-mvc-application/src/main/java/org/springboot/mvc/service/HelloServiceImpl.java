package org.springboot.mvc.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			log.error("error", e);
		}
		return "hellow from springboot mvc application";
	}

}
