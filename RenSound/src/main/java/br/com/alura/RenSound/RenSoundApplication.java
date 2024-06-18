package br.com.alura.RenSound;

import br.com.alura.RenSound.main.Principal;
import br.com.alura.RenSound.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;

@SpringBootApplication
public class RenSoundApplication implements CommandLineRunner{
	@Autowired
	private SingerRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(RenSoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Hello World, by Renthon34!");
			Principal principal = new Principal(repositorio);
			principal.exibeMenu();
		} catch (InputMismatchException e){
			System.out.println("Valor inserido inválido");
		}

	}

}
