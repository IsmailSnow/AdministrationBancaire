package com.master.aod.entities.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.master.aod.entities.User.Authority;
import com.master.aod.entities.User.AuthorityName;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Optional<Authority> findByName(AuthorityName roleUser);
}
