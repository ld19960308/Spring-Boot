import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Application;
import com.entity.Address;
import com.mapper.AddressMapper;
import com.mapper.UserMapper;
@SpringBootTest(classes=Application.class)
@RunWith(SpringRunner.class)
public class OneToOneTest {
	
	@Autowired
	AddressMapper addressMapper;
	
	@Autowired
	UserMapper userMapper;

	@Test
	public void test() {
		//User user=userMapper.selectUserById("li");
		//System.out.println(user.getName());
		Address address=addressMapper.selectAddressById("1");
		System.out.println(address.getDetail());
	}

}
