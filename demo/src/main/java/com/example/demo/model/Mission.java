package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Boolean isCompleted;

    @ManyToMany
    @JoinTable(name = "participant_in_missions",
        joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "SuperHero_id"))
    private List<SuperHero> heroes;

    public Mission(){

    }

    public Mission(String name, Boolean isCompleted){
        this.name = name;
        this.isCompleted = isCompleted;
    }
}
