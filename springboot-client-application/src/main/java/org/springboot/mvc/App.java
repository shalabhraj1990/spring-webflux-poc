package org.springboot.mvc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			long startTime = System.currentTimeMillis();
			WebClient client = WebClient.builder().baseUrl("http://localhost:8080/hi").build();
			ExecutorService es = Executors.newFixedThreadPool(1000);
			for (int i = 0; i < 500; i++) {
				es.submit(() -> {
					String message = client.get().retrieve().bodyToMono(String.class).block();
					log.warn(message);
				});
			}
			es.shutdown();
			while (!es.isTerminated()) {
				log.warn("mili sec: "+ (startTime - System.currentTimeMillis()));

			}
		};
	}
}
