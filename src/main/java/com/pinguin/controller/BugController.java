package com.pinguin.controller;

import com.pinguin.dto.BugDto;
import com.pinguin.service.BugService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/bug")
    public ResponseEntity<Void> deleteById(@RequestParam("issue-id") String issueId){
        try {
            bugService.deleteByIssueId(issueId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/bug")
    public ResponseEntity<BugDto> getById(@RequestParam("issue-id") String issueId){
        try {
            return ResponseEntity.ok(bugService.findBugByIssueId(issueId));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/bugs")
    public ResponseEntity<List<BugDto>> getBugs(){
        try {
            return ResponseEntity.ok(bugService.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/assign")
    public ResponseEntity<BugDto> assign(@RequestParam("issue-id") String issueId,
                                        @RequestParam("developer-id") String developerId){
        try {
            return ResponseEntity.ok(bugService.assignDeveloper(issueId,developerId));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/bug")
    public ResponseEntity<BugDto> update(@RequestBody BugDto bugDto){
        try {
            return ResponseEntity.ok(bugService.update(bugDto));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }


}
