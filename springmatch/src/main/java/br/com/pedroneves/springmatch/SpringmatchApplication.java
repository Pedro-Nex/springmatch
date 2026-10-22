package br.com.pedroneves.springmatch;

import br.com.pedroneves.springmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal main = new Principal();
		main.exibeMenu();
	}
}
