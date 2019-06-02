import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Application;
import com.dao.RoleRepository;
import com.dao.UserRepository;
import com.dao.UserRoleRepository;
import com.entity.Role;
import com.entity.User;
import com.entity.UserRole;
import com.entity.UserRolePK;
import com.specification.UserRoleSpecification;
import com.specification.UserSpecification;

@SpringBootTest(classes=Application.class)
@RunWith(SpringRunner.class)
public class ManyToMany {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void test() {
       //this.ManyToManyOne();
		//this.ManyToManyTwo();
		//this.selectBySpecification();
	}
	private void selectBySpecification(){
		UserSpecification spe=new UserSpecification();
		List<User> users=this.userRepository.findAll(spe);
		for(User u:users){
			System.out.println(u.getName());
		}
	}
	private void ManyToManyTwo(){
		Role role10=roleRepository.findById("10").get();
		Role role30=roleRepository.findById("30").get();
		
		List<UserRole> userRoles=new ArrayList<>();
		
		User u=this.userRepository.findById("li").get();
		this.userRepository.delete(u);
		
		User user=new User();
		user.setId("li");
		user.setName("li");

        UserRole userRole10=new UserRole();
        userRole10.setId(new UserRolePK(role10.getId(),user.getId()));
        
        UserRole userRole30=new UserRole();
        userRole30.setId(new UserRolePK(role30.getId(),user.getId()));
        
        userRoles.add(userRole30);
        userRoles.add(userRole10);
        
        user.setUserRoles(userRoles);
		
		userRepository.save(user);
	}
	private void ManyToManyOne(){
		/*Role role10=roleRepository.findById("10").get();
		Role role30=roleRepository.findById("30").get();
		
		User user=new User();
		user.setId("li");
		user.setName("li");
		List<Role> userRoles=new ArrayList<>();
		userRoles.add(role10);
		userRoles.add(role30);
		user.setRoles(userRoles);
		
		List<Role> user1Roles=new ArrayList<>();
		user1Roles.add(role10);
		userRepository.save(user);*/
		
		/*User user1=new User();
		user1.setId("zhang");
		user1.setName("zhang");
		UserRole userRole4=new UserRole();
		UserRolePK id2=new UserRolePK();
		id2.setRoleId("20");
		id2.setUserId(user1.getId());
		userRole4.setId(id2);
		userRoleL.clear();
		userRoleL.add(userRole4);
		user1.setUserRoles(userRoleL);
		userRepository.save(user1);
		
		userRepository.delete(user1);*/
		
	}

}

