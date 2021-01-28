package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

   Role findByRoleName(String roleName);
}
