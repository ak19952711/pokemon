package com.pokeworld.pokemon.web.trashcan.patterns.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void updateState();
}
