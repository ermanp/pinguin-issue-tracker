package com.pinguin.repository;

import com.pinguin.model.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story,Long> {
}
