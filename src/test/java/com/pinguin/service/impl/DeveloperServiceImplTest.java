package com.pinguin.service.impl;

import com.pinguin.dto.DeveloperDto;
import com.pinguin.mapper.DeveloperMapper;
import com.pinguin.model.Developer;
import com.pinguin.repository.DeveloperRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DeveloperServiceImplTest {

    @InjectMocks
    private DeveloperServiceImpl developerService;
    @Mock
    private DeveloperRepository developerRepository;
    @Mock
    private DeveloperMapper mapper;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAll() {
        Developer dev1 = new Developer(1l,"nick",new HashSet<>());
        Developer dev2 = new Developer(2l,"cave",new HashSet<>());
        Mockito.when(developerRepository.findAllBy()).thenReturn(Arrays.asList(dev1,dev2));
        List<DeveloperDto> developerDtos = developerService.getAll();
        assertEquals(2,developerDtos.size());
    }

    @Test
    void getDeveloperById() {
        Developer dev1 = new Developer(1l,"nick",new HashSet<>());
        Mockito.when(developerRepository.findById(1l)).thenReturn(Optional.of(dev1));
        Optional<Developer> dev = developerService.getDeveloperById(dev1.getId());
        assertEquals(dev.get().getId(),dev1.getId());
        assertEquals(dev.get().getName(),dev1.getName());
        assertEquals(dev.get().getStories().size(),dev1.getStories().size());

    }
}