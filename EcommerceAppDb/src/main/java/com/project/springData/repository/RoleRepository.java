package com.project.springData.repository;

import com.project.springData.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role findByName(String name);
}
