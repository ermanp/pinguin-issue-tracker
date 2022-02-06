package com.pinguin.controller;

import com.pinguin.dto.BugDto;
import com.pinguin.service.BugService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class BugController {

    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @PostMapping("/bugs")
    public ResponseEntity<Void> saveAll(@RequestBody List<BugDto> bugDtoList) {
        try {
            bugService.saveAll(bugDtoList);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

}
