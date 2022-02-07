package com.pinguin.service;

import com.pinguin.dto.StoryDto;

import java.util.List;

public interface StoryService {

    void saveAll(List<StoryDto> storyDtoList);
}
