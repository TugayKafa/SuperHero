package com.example.demo.exceptions;

public class MissionNotFoundException extends RuntimeException{
    public MissionNotFoundException(Long id){
        super("Mission id not found: "+ id);
    }
}
