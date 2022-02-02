package com.example.demo.controller;

import com.example.demo.dto.MissionDto;
import com.example.demo.exceptions.MissionNotFoundException;
import com.example.demo.model.Mission;
import com.example.demo.service.Mission.MissionService;
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
@RequestMapping("/Mission")
public class MissionController {
    @Autowired
    private MissionService service;

    private ModelMapper mapper = new ModelMapper();

    @PostMapping
    ResponseEntity<MissionDto> createMission(@RequestBody MissionDto missionDto) {
        Mission mission = mapper.map(missionDto,Mission.class);
        //Mission mission = new Mission(missionDto.getName(),missionDto.getIsCompleted());
        MissionDto mappedDto = mapper.map(service.save(mission), MissionDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Mission> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    ResponseEntity<MissionDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Mission> optionalMission = service.findById(id);
        if (optionalMission.isEmpty()) {
            throw new MissionNotFoundException(id);
        }
        MissionDto mappedDto = mapper.map(optionalMission.get(), MissionDto.class);
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
