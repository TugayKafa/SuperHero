package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class MissionDto {

    @NotNull
    private String name;

    @NotNull
    private Boolean isCompleted;
}
