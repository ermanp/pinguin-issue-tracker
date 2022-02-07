package com.pinguin.service.impl;

import com.pinguin.dto.StoryDto;
import com.pinguin.mapper.StoryMapper;
import com.pinguin.repository.StoryRepository;
import com.pinguin.service.StoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final StoryMapper mapper;

    public StoryServiceImpl(StoryRepository storyRepository, StoryMapper mapper) {
        this.storyRepository = storyRepository;
        this.mapper = mapper;
    }


    @Override
    public void saveAll(List<StoryDto> storyDtoList) {
        storyRepository.saveAll(storyDtoList.stream().map(mapper::fromDto).collect(Collectors.toList()));

    }
}
