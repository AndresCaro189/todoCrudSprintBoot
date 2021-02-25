package org.example.sprintboot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findAllByGroupListId(String groupListId);
}

