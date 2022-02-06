package com.pinguin.mapper;

import com.pinguin.dto.BugDto;
import com.pinguin.model.Bug;

public interface BugMapper {

    Bug fromDto(BugDto bugDto);
}
