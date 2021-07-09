package com.pokeworld.pokemon.web.trashcan.patterns.observer;

public class JanObserver extends Observer{
    public final String observerName="Jan";

    public JanObserver(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }

    @Override
    public void updateState() {
        System.out.println(observerName+" adds 3 to state "+(Integer)(this.subject.getState()+3));
    }
}
