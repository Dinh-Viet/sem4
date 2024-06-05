package com.example.apf.Repository;

import com.example.apf.Entity.Role;
import com.example.apf.Entity.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleId> {
}
