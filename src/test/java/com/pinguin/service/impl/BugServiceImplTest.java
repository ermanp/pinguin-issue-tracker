package com.pinguin.service.impl;

import com.pinguin.dto.BugDto;
import com.pinguin.exception.DeveloperNotFoundException;
import com.pinguin.mapper.impl.BugMapperImpl;
import com.pinguin.model.Bug;
import com.pinguin.model.Developer;
import com.pinguin.repository.BugRepositoy;
import com.pinguin.repository.DeveloperRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class BugServiceImplTest {

    @InjectMocks
    private BugServiceImpl bugService;
    @Mock
    private BugRepositoy bugRepositoy;
    @Mock
    private BugMapperImpl mapper;
    @Mock
    private DeveloperRepository developerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveAll() {
    }

    @Test
    void deleteByIssueId() {
    }

    @Test
    void findBugByIssueId() {
    }

    @Test
    void findAll() {
    }

    @Test
    void assigneDeveloper() throws DeveloperNotFoundException {
        String issueId = "100";
        String developerId = "900";

        Bug bug = new Bug();
        bug.setIssueId(100l);
        bug.setTitle("title");
        bug.setStatus("status");
        bug.setPriority("priority");
        bug.setDescription("description");
        bug.setCreatedAt("11-11-2021");

        BugDto dto = new BugDto();
        dto.setIssueId("100");
        dto.setTitle("title");
        dto.setStatus("status");
        dto.setPriority("priority");
        dto.setDescription("description");
        dto.setCreatedAt("11-11-2021");
        dto.setDeveloperId("900");

        Developer dev1 = new Developer(100l,"nick",new HashSet<>());

        Mockito.when(bugRepositoy.findBugByIssueId(Long.valueOf(issueId))).thenReturn(bug);
        Mockito.when(developerRepository.findById(Long.valueOf(developerId))).thenReturn(Optional.of(dev1));
        Mockito.when(bugRepositoy.save(bug)).thenReturn(bug);
        Mockito.when(mapper.toDto(bug)).thenReturn(dto);
        BugDto result = bugService.assigneDeveloper(issueId, developerId);
        assertEquals(issueId,result.getIssueId());
        assertEquals(developerId,result.getDeveloperId());

    }

    @Test
    void update() {
        BugDto dto = new BugDto();
        dto.setIssueId("1");
        dto.setTitle("title");
        dto.setStatus("status");
        dto.setPriority("priority");
        dto.setDescription("description");
        dto.setCreatedAt("11-11-2021");
        dto.setDeveloperId("1");

        Bug bug = new Bug();
        bug.setIssueId(1l);
        bug.setTitle("title");
        bug.setStatus("status");
        bug.setPriority("priority");
        bug.setDescription("description");
        bug.setCreatedAt("11-11-2021");

        Developer developer = mock(Developer.class);
        Mockito.when(developerRepository.findById(Long.valueOf(dto.getDeveloperId())))
                .thenReturn(Optional.ofNullable(developer));
        Mockito.when(bugRepositoy.save(bug)).thenReturn(bug);
        Mockito.when(mapper.fromDto(dto)).thenReturn(bug);

        bugService.update(dto);
        assertEquals(dto.getTitle(),bug.getTitle());
        assertEquals(dto.getStatus(),bug.getStatus());


    }
}