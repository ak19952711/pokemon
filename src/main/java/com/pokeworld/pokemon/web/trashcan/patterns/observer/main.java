package com.pokeworld.pokemon.web.trashcan.patterns.observer;

import com.pokeworld.pokemon.web.trashcan.patterns.observer.JanObserver;
import com.pokeworld.pokemon.web.trashcan.patterns.observer.JimObserver;
import com.pokeworld.pokemon.web.trashcan.patterns.observer.KevinObserver;
import com.pokeworld.pokemon.web.trashcan.patterns.observer.Subject;
import java.util.ArrayList;
public class main {

    public static void main(String[] args) throws InterruptedException {

        Subject subject=new Subject();
        new KevinObserver(subject);
        new JimObserver(subject);
        new JanObserver(subject);

        System.out.println("state change to 15");
        subject.setState(15);
        Thread.sleep(3000);
        System.out.println("state change to 23");
        subject.setState(23);
        Thread.sleep(3000);
        System.out.println("state change to 67");
        subject.setState(67);

    }


}
