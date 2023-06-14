package com.BlogAppApis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogAppApis.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
