package com.example.demo.service.SuperHero;

import com.example.demo.model.SuperHero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SuperHeroService {
    SuperHero save(SuperHero hero);

    Optional<SuperHero> findById(Long id);

    void deleteById(Long id);

    Page<SuperHero> findAll(Pageable pageable);
}
