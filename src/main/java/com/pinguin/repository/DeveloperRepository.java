package com.pinguin.repository;

import com.pinguin.model.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {

    List<Developer> findAllBy();

}
