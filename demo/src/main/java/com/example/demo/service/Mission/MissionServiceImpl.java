package com.example.demo.service.Mission;

import com.example.demo.model.Mission;
import com.example.demo.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissionServiceImpl implements MissionService{

    @Autowired
    private MissionRepository repository;

    @Override
    public Mission save(Mission mission) {
        return repository.save(mission);
    }

    @Override
    public Optional<Mission> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Mission> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
