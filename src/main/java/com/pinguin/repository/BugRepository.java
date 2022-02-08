package com.pinguin.repository;

import com.pinguin.model.Bug;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BugRepository extends CrudRepository<Bug, Long> {

    void deleteBugByIssueId(Long issueId);

    Bug findBugByIssueId(Long issueId);

    List<Bug> findAll();

    Bug save(Bug bug);
}
