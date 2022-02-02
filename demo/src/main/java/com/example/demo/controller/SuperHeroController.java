package com.example.demo.controller;

import com.example.demo.dto.SuperHeroDto;
import com.example.demo.exceptions.SuperHeroNotFoundException;
import com.example.demo.model.SuperHero;
import com.example.demo.service.SuperHero.SuperHeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/SuperHero")
public class SuperHeroController {

    @Autowired
    private SuperHeroService service;

    ModelMapper mapper = new ModelMapper();

    @PostMapping
    ResponseEntity<SuperHeroDto> createSuperHero(@RequestBody SuperHeroDto heroDto) {
        SuperHero superHero = mapper.map(heroDto, SuperHero.class);
        SuperHeroDto mappedDto = mapper.map(service.save(superHero), SuperHeroDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<SuperHero> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    ResponseEntity<SuperHeroDto> findById(@PathVariable(value = "id") Long id) {
        Optional<SuperHero> optionalSuperHero = service.findById(id);
        if (optionalSuperHero.isEmpty()) {
            throw new SuperHeroNotFoundException(id);
        }
        SuperHeroDto mappedDto = mapper.map(optionalSuperHero.get(), SuperHeroDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
