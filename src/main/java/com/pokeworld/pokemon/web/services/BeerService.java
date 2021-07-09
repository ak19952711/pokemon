package com.pokeworld.pokemon.web.services;

import com.pokeworld.pokemon.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto saveNewBeer(BeerDto beerDto);
    BeerDto getBeerById(UUID beerId);
    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}
