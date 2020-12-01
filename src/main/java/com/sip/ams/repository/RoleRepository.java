package com.sip.ams.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;

public interface RoleRepository extends JpaRepository<Role,Integer> {
	Role findByRole(String role);
}
