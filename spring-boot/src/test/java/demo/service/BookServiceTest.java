package demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE) // 스프링통합테스트(스프링부트 어플리케이션 테스트에 필요한 거의 모든 의존성제공)
// @WebMvcTest, @DataJpaTest, @RestClientTest, @JsonTest <- 얘네들은 단위테스트임
public class BookServiceTest {
	@Autowired
	BookService bookService;

	@Test(expected = RuntimeException.class)
	public void testFindById() {
		Long id = 1L;
		bookService.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

	}
}
