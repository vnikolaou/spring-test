package com.xyz.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xyz.test.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
