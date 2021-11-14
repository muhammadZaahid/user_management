package com.zaahid.user_management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zaahid.user_management.model.UserAuth;

public interface UserAuthRepository extends CrudRepository<UserAuth, Long> {

	@Query("SELECT u from User u Where u.username = :username")
	public UserAuth getUserByUsername(@Param("username") String username);
	
}
