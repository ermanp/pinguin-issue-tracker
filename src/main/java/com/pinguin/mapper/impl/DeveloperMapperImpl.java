package com.pinguin.mapper.impl;

import com.pinguin.dto.DeveloperDto;
import com.pinguin.mapper.DeveloperMapper;
import com.pinguin.model.Developer;
import org.springframework.stereotype.Service;

@Service
public class DeveloperMapperImpl implements DeveloperMapper {
    @Override
    public Developer fromDto(DeveloperDto developerDto) {
        return new Developer(developerDto.getName());
    }

    @Override
    public DeveloperDto toDto(Developer developer) {
        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setName(developer.getName());
        return developerDto;
    }
}
