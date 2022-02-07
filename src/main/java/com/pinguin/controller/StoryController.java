package com.pinguin.controller;

import com.pinguin.dto.StoryDto;
import com.pinguin.service.StoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("/stories")
    public ResponseEntity<Void> saveAll(@RequestBody List<StoryDto> storyDtoList) {
        try {
            storyService.saveAll(storyDtoList);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }
}
