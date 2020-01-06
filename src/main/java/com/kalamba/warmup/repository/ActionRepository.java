package com.kalamba.warmup.repository;

import com.kalamba.warmup.model.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends CrudRepository<Action, Integer> {
}
