package com.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.entity.UserRole;
import com.entity.UserRolePK;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK>,JpaSpecificationExecutor<UserRole>{

}
