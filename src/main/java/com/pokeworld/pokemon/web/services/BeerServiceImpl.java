package com.pokeworld.pokemon.web.services;

import com.pokeworld.pokemon.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService{


    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDto getBeerById(UUID beerId){
       return BeerDto.builder().id(UUID.randomUUID())
               .beerName("Carlson")
               .beerStyle("Pale Ale")
               .build();
    }
    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Beer is updated. Enjoy!!!");
    }
    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Beer is deleted. What now!!!");
    }
}
