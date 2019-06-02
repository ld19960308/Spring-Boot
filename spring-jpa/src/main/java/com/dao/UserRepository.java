package com.dao;


import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{
	
	@Query("select new map(u.id as id) from User u where u.id='li'")
	public Map<String,String> selectAll();

}
