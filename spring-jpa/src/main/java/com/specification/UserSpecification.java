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

public class UserSpecification implements Specification<User> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] roles={
			"10","20","40","30"
	};

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		List<Predicate> predicates=new ArrayList<>();
		//predicates.add(builder.equal(root.get("id"), "li"));
		predicates.add(builder.like(root.get("name"), "a%"));
		List<Predicate> rolePredicate=new ArrayList<>();
		for(String s:roles){
			//Root<UserRole> userRoleRoot=query.from(UserRole.class);
			Join<User,UserRole> userRole_user=root.join("userRoles", JoinType.INNER);
			//predicates.add(builder.equal(userRoleRoot.get("id").get("userId"),root.get("id")));
			rolePredicate.add(builder.equal(userRole_user.get("id").get("roleId"), s));
		}
		Predicate userPre=builder.and(predicates.toArray(new Predicate[predicates.size()]));
		Predicate rolePre=builder.and(rolePredicate.toArray(new Predicate[rolePredicate.size()]));

		return query.where(builder.and(userPre,rolePre)).getRestriction();
		//return builder.or(userPre,rolePre);
		
	}

}
