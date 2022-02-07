package com.pinguin.mapper;

import com.pinguin.dto.StoryDto;
import com.pinguin.model.Story;

public interface StoryMapper {

    Story fromDto(StoryDto storyDto);
}
