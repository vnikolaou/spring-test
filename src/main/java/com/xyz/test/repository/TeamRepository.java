package com.xyz.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xyz.test.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, String> {

}
