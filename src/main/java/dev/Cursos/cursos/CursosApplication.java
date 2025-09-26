package dev.Cursos.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CursosApplication {
	
	public static void main(String[] args) {
		Dotenv.configure().load();
		SpringApplication.run(CursosApplication.class, args);
		System.out.println("Aplicação iniciada com sucesso!");
	}

}
