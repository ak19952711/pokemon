package com.pokeworld.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		System.out.println("Master Branch");

		SpringApplication.run(PokemonApplication.class, args);
	}

}
