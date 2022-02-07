package com.pinguin.service;

import com.pinguin.dto.BugDto;
import com.pinguin.exception.DeveloperNotFoundException;

import java.text.ParseException;
import java.util.List;


public interface BugService {

    void saveAll(List<BugDto> bugDtoList) throws DeveloperNotFoundException, ParseException;

    void deleteByIssueId(String id);

    BugDto findBugByIssueId(String issueId);

    List<BugDto> findAll();

    BugDto assigneDeveloper(String issueId, String developerId) throws DeveloperNotFoundException;

    BugDto update(BugDto bugDto);
}
