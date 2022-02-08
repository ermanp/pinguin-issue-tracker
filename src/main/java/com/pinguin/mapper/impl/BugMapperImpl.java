package com.pinguin.mapper.impl;

import com.pinguin.dto.BugDto;
import com.pinguin.mapper.BugMapper;
import com.pinguin.model.Bug;
import com.pinguin.model.Developer;
import com.pinguin.service.DeveloperService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class BugMapperImpl implements BugMapper {

    private final DeveloperService developerService;

    public BugMapperImpl(DeveloperService developerService) {
        this.developerService = developerService;
    }

    /**
     * Method check developerId coming from Dto object
     * If exists, retrieve from db and assign to bug
     * If not exist or not found, creates the bug without assigned developer.
    * */
    public Bug fromDto(BugDto bugDto){
        Bug bug = new Bug();
        if(!ObjectUtils.isEmpty(bugDto.getIssueId()))
            bug.setIssueId(Long.valueOf(bugDto.getIssueId()));

        bug.setDescription(bugDto.getDescription());
        bug.setPriority(bugDto.getPriority());
        bug.setStatus(bugDto.getStatus());
        bug.setTitle(bugDto.getTitle());
        bug.setCreatedAt(bugDto.getCreatedAt());

        if(!bugDto.getDeveloperId().isEmpty()){
            Developer developer1;
            Optional<Developer> developer = developerService.getDeveloperById(Long.valueOf(bugDto.getDeveloperId()));
            if(developer.isPresent()){
                developer1 = developer.get();
                bug.setDeveloper(developer1);
            }
        }
        return bug;
    }

    @Override
    public BugDto toDto(Bug bug) {
        BugDto bugDto = new BugDto();
        bugDto.setIssueId(String.valueOf(bug.getIssueId()));
        bugDto.setDescription(bug.getDescription());
        bugDto.setCreatedAt(bug.getCreatedAt());
        if(bug.getDeveloper() != null)
            bugDto.setDeveloperId(String.valueOf(bug.getDeveloper().getId()));
        bugDto.setPriority(bug.getPriority());
        bugDto.setStatus(bug.getStatus());
        bugDto.setTitle(bug.getTitle());
        return bugDto;
    }
}
