package com.example.demo.exceptions;

public class SuperHeroNotFoundException extends RuntimeException {
    public SuperHeroNotFoundException(Long id){
        super("Super Hero id not found: "+ id);
    }
}
