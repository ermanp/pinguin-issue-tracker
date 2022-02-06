package com.pinguin.service.impl;

import com.pinguin.dto.BugDto;
import com.pinguin.mapper.BugMapper;
import com.pinguin.repository.BugRepositoy;
import com.pinguin.service.BugService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements BugService {
    private final BugRepositoy bugRepositoy;
    private final BugMapper mapper;

    public BugServiceImpl(BugRepositoy bugRepositoy, BugMapper mapper) {
        this.bugRepositoy = bugRepositoy;
        this.mapper = mapper;
    }

    @Override
    public void saveAll(List<BugDto> bugDtoList) {
        bugRepositoy.saveAll(bugDtoList.stream().map(mapper::fromDto).collect(Collectors.toList()));
    }
}
