package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.entity.User;
//@Mapper
public interface UserMapper {
	
	@Select("select * from user where id=${id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name")
	})
	User selectUserById(String id);

}
