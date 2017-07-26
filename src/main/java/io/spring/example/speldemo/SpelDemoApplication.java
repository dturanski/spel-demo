package io.spring.example.speldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("config.xml")
public class SpelDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpelDemoApplication.class, args);
	}
}
