package com.pokeworld.pokemon.web.controller;

import com.pokeworld.pokemon.web.model.BeerDto;
import com.pokeworld.pokemon.web.services.BeerService;
import com.pokeworld.pokemon.web.services.PassEncoderDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
    @Autowired
    PassEncoderDecoder passEncoderDecoder;

    @GetMapping("/encode/{pass}")
    public ResponseEntity<String> getEncrpted(HttpRequest request, HttpResponse response, @PathVariable("pass") String pass){

        return new ResponseEntity<>(passEncoderDecoder.getPasswordEncoder().encode(pass), HttpStatus.OK);

    }

    @GetMapping("/decode/{raw}/{encoded}")
    public ResponseEntity<Boolean> getDencrpted(@PathVariable("raw") String raw,@PathVariable("encoded") String enc){

        return new ResponseEntity<>(passEncoderDecoder.getPasswordEncoder().matches(raw,enc), HttpStatus.OK);

    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity getBeer(@RequestBody BeerDto beerDto){
        BeerDto savedDto=beerService.saveNewBeer(beerDto);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+savedDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId,beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerById(beerId);
    }
}
