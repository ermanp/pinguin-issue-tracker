package com.pinguin.service.impl;

import com.pinguin.dto.DeveloperDto;
import com.pinguin.mapper.DeveloperMapper;
import com.pinguin.model.Developer;
import com.pinguin.repository.DeveloperRepository;
import com.pinguin.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper mapper;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, DeveloperMapper mapper) {
        this.developerRepository = developerRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveAll(List<DeveloperDto> developerList) {
        developerRepository.saveAll(developerList.stream().map(mapper::fromDto).collect(Collectors.toList()));

    }

    @Override
    public List<DeveloperDto> getAll() {
        return developerRepository.findAllBy().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<Developer> getDeveloperById(Long id) {
        return developerRepository.findById(id);
    }
}
