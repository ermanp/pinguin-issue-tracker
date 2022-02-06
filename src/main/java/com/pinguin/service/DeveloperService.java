package com.pinguin.service;

import com.pinguin.dto.DeveloperDto;
import com.pinguin.model.Developer;

import java.util.List;
import java.util.Optional;

public interface DeveloperService {

    void saveAll(List<DeveloperDto> developerDtoList);

    List<DeveloperDto> getAll();

    Optional<Developer> getDeveloperById(Long id);
}
