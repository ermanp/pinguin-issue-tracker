package com.pinguin.mapper.impl;

import com.pinguin.dto.BugDto;
import com.pinguin.mapper.BugMapper;
import com.pinguin.model.Bug;
import com.pinguin.model.Developer;
import com.pinguin.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BugMapperImpl implements BugMapper {

    private final DeveloperService developerService;

    public BugMapperImpl(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public Bug fromDto(BugDto bugDto){
        Developer developer1 = new Developer();
        if(!bugDto.getDeveloperId().isEmpty()){
            Optional<Developer> developer = developerService.getDeveloperById(Long.valueOf(bugDto.getDeveloperId()));
            if(developer.isPresent()){
                developer1 = developer.get();
            }
        }

        return new Bug(bugDto.getTitle(),bugDto.getDescription(), bugDto.getCreatedAt(),developer1,
                bugDto.getStatus(),bugDto.getPriority());

    }
}
