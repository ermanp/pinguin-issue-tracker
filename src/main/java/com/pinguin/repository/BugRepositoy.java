package com.pinguin.repository;

import com.pinguin.model.Bug;
import org.springframework.data.repository.CrudRepository;

public interface BugRepositoy extends CrudRepository<Bug, Long> {
}
