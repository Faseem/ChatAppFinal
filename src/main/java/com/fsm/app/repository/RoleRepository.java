package com.fsm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.app.entity.Role;
import com.fsm.app.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	List<Role> findByUsers(User user);

	Role findByName(String name);

}
