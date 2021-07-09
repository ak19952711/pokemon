package com.pokeworld.pokemon.web.trashcan.patterns.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Subject {

    private List<Observer> observers=new ArrayList<>();
    private int state=0;

    public void setState(int state){
        this.state=state;
        notifyAllObservers();
    }
    public void attach(Observer observer){
        this.observers.add(observer);
    }
    public void notifyAllObservers(){
        System.out.println("Notifying all Obeservers");
        for(Observer observer: observers){
            observer.updateState();
        }

    }
}
