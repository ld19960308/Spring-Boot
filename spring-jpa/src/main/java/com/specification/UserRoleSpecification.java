package com.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.entity.User;
import com.entity.UserRole;

public class UserRoleSpecification implements Specification<UserRole> {
	
	String[] roles=new String[]{
		"10","30"	
	};

	@Override
	public Predicate toPredicate(Root<UserRole> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Root<User> userRoot=query.from(User.class);
		List<Predicate> list=new ArrayList<>();
		for(String s:roles){
			//Root<UserRole> userRoleRoot=query.from(UserRole.class);
			Join<User,UserRole> userRole_user=root.join("userRoles", JoinType.INNER);
			//predicates.add(builder.equal(userRoleRoot.get("id").get("userId"),root.get("id")));
			list.add(builder.equal(userRole_user.get("id").get("roleId"), s));
		}
		return query.where(list.toArray(new Predicate[list.size()])).getRestriction();
	}

}
