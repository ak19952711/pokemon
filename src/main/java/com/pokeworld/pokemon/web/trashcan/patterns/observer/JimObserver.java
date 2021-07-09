package com.pokeworld.pokemon.web.trashcan.patterns.observer;

public class JimObserver extends Observer{
    public final String observerName="Jim";

    public JimObserver(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }

    @Override
    public void updateState() {
        System.out.println(observerName+" adds 2 to state "+(Integer)(this.subject.getState()+2));
    }
}
