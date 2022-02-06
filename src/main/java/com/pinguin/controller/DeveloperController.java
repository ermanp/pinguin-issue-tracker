package com.pinguin.controller;

import com.pinguin.dto.DeveloperDto;
import com.pinguin.service.DeveloperService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping("/developers")
    public ResponseEntity<Void> saveAll(@RequestBody List<DeveloperDto> developerDtoList){
        try {
            developerService.saveAll(developerDtoList);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/developers")
    public ResponseEntity<List<DeveloperDto>> getAll(){
        try {
            return ResponseEntity.ok(developerService.getAll());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();

    }
}
