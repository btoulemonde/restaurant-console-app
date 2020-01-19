package dev.ihm.options;

import org.springframework.stereotype.Component;

import dev.exception.PlatException;


public class OptionTerminer implements IOptionMenu {
    @Override
    public String getTitre() {
        return "Terminer";
    }

    @Override
    public void executer() {
        throw new PlatException("Au revoir");
        
    }
}
