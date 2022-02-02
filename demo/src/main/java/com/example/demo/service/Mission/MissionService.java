package com.example.demo.service.Mission;

import com.example.demo.model.Mission;
import com.example.demo.model.SuperHero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MissionService {
    Mission save(Mission mission);

    Optional<Mission> findById(Long id);

    void deleteById(Long id);

    Page<Mission> findAll(Pageable pageable);
}
