package com.pokeworld.pokemon.web.trashcan.patterns.observer;

public class KevinObserver extends Observer{
    public final String observerName="kevin";

    public KevinObserver(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void updateState() {
        System.out.println(observerName+" adds 1 to state "+(Integer)(this.subject.getState()+1));
    }
}
