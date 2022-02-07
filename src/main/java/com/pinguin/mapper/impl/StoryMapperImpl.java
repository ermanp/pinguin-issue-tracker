package com.pinguin.mapper.impl;

import com.pinguin.dto.StoryDto;
import com.pinguin.mapper.StoryMapper;
import com.pinguin.model.Developer;
import com.pinguin.model.Story;
import com.pinguin.service.DeveloperService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class StoryMapperImpl implements StoryMapper {

    private final DeveloperService developerService;

    public StoryMapperImpl(DeveloperService developerService) {
        this.developerService = developerService;
    }


    @Override
    public Story fromDto(StoryDto storyDto) {
        Story story = new Story();
        if(!ObjectUtils.isEmpty(storyDto.getIssueId()))
            story.setIssueId(Long.valueOf(storyDto.getIssueId()));

        story.setCreatedAt(storyDto.getCreatedAt());
        story.setDescription(storyDto.getDescription());
        story.setStatus(story.getStatus());
        story.setTitle(story.getTitle());
        story.setEstimatedPoint(storyDto.getEstimatedPoint());

        if(!storyDto.getDeveloperId().isEmpty()){
            Optional<Developer> developer = developerService.getDeveloperById(Long.valueOf(storyDto.getDeveloperId()));
            if(developer.isPresent()){
                story.setDeveloper(developer.get());
            }
        }
        return story;

    }
}
