package com.gl.CollegeFest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.CollegeFest.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String username);

}
