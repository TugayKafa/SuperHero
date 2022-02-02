package com.example.demo.service.SuperHero;

import com.example.demo.model.SuperHero;
import com.example.demo.repository.SuperHeroRepository;
import com.example.demo.service.SuperHero.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public SuperHero save(SuperHero hero) {
        return repository.save(hero);
    }

    @Override
    public Optional<SuperHero> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<SuperHero> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
