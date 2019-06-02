import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Application;
import com.dao.UserRepository;
import com.entity.User;
@SpringBootTest(classes=Application.class)
@RunWith(SpringRunner.class)
public class RepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	

	@Test
	public void test() {
	   List<User> users=this.userRepository.findAll();
	   for(User u:users){
		   System.out.println(u.getId()+":"+u.getName());
	   }
       Map<String,String> map=this.userRepository.selectAll();
       Iterator<String> keySet=map.keySet().iterator();
       while(keySet.hasNext()){
    	   String key=keySet.next();
    	   System.out.println(key+":"+map.get(key));
       }
	}

}
