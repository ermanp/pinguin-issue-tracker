package com.pinguin.service.impl;

import com.pinguin.dto.BugDto;
import com.pinguin.exception.DeveloperNotFoundException;
import com.pinguin.mapper.BugMapper;
import com.pinguin.model.Bug;
import com.pinguin.model.Developer;
import com.pinguin.repository.BugRepositoy;
import com.pinguin.repository.DeveloperRepository;
import com.pinguin.service.BugService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class BugServiceImpl implements BugService {
    private final BugRepositoy bugRepositoy;
    private final DeveloperRepository developerRepository;
    private final BugMapper mapper;

    public BugServiceImpl(BugRepositoy bugRepositoy, DeveloperRepository developerRepository, BugMapper mapper) {
        this.bugRepositoy = bugRepositoy;
        this.developerRepository = developerRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveAll(List<BugDto> bugDtoList) {
        bugRepositoy.saveAll(bugDtoList.stream().map(mapper::fromDto).collect(Collectors.toList()));
    }

    @Override
    public void deleteByIssueId(String issueId) {
        bugRepositoy.deleteBugByIssueId(Long.valueOf(issueId));
    }

    @Override
    public BugDto findBugByIssueId(String issueId) {
        return mapper.toDto(bugRepositoy.findBugByIssueId(Long.valueOf(issueId)));
    }

    @Override
    public List<BugDto> findAll() {
        return bugRepositoy.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BugDto assigneDeveloper(String issueId, String developerId) throws DeveloperNotFoundException {
        Bug bug = bugRepositoy.findBugByIssueId(Long.valueOf(issueId));
        Optional<Developer> developer = developerRepository.findById(Long.valueOf(developerId));
        if(!developer.isPresent()){
            throw new DeveloperNotFoundException();
        }
        bug.setDeveloper(developer.get());
        return mapper.toDto(bugRepositoy.save(bug));
    }

    @Override
    public BugDto update(BugDto bugDto) {
        Bug obj = mapper.fromDto(bugDto);
        obj.setTitle(bugDto.getTitle());
        obj.setIssueId(Long.valueOf(bugDto.getIssueId()));
        obj.setCreatedAt(bugDto.getCreatedAt());
        obj.setStatus(bugDto.getStatus());
        obj.setPriority(bugDto.getPriority());
        obj.setDescription(bugDto.getDescription());
        Optional<Developer> developer = developerRepository.findById(Long.valueOf(bugDto.getDeveloperId()));
        obj.setDeveloper(developer.get());
        return mapper.toDto(bugRepositoy.save(obj));
    }
}
