package com.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.entity.Address;
//@Mapper
public interface AddressMapper {
	@Insert("insert into address(id,detail,user_id) values(#{id},#{detail},#{user.id})")
	int save(Address a);
	@Delete("delete from address where id=#{id}")
	int delete(Integer id);
	@Update("update address set detail=#{detail}")
	int modify(Address a);
	@Select("select * from address where id=#{id}")
	@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="detail",property="detail"),
			@Result(column="user_id",property="user",
			one=@One(select="com.mapper.UserMapper.selectUserById",fetchType=FetchType.EAGER))
			})
	Address selectAddressById(String id);
	
	
	

}
