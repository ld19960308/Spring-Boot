import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Application;
import com.dao.AuthorRepository;
import com.dao.BookRepository;
import com.entity.Author;
import com.entity.Book;
@SpringBootTest(classes=Application.class)
@RunWith(SpringRunner.class)
public class OneToMany {
	
	@Autowired
	private AuthorRepository ar;
	
	@Autowired
	private BookRepository br;

	@Test
	public void test() {
		/*insert
		 * Author author=new Author();
		author.setId("1");
		author.setName("li");
		
		Book book1=new Book();
		book1.setId("1");
		book1.setName("book1");
		
		author.addBook(book1);
		
		Book book2=new Book();
		book2.setId("2");
		book2.setName("book2");
		
		author.addBook(book2);
		
		ar.save(author);*/
		
		//Author author=ar.findById("li").get();
		ar.deleteById("li");
	}

}
