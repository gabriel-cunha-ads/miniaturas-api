package br.com.gabrielcunha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.gabrielcunha")
public class MiniaturasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniaturasApplication.class, args);
	}

}
