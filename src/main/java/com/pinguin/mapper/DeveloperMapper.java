package com.pinguin.mapper;

import com.pinguin.dto.DeveloperDto;
import com.pinguin.model.Developer;

public interface DeveloperMapper {

    Developer fromDto(DeveloperDto developerDto);

    DeveloperDto toDto(Developer developer);
}
