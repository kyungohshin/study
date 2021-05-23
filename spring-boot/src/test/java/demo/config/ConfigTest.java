package demo.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import demo.domain.Config;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = { BaseConfig.class, ProdConfig.class, TestConfig.class })
// properties는 디폴트라 안붙여도그만
@SpringBootTest(properties = "spring.config.location=classpath:application.yml")
public class ConfigTest {
	@Autowired
	private Config hello;

	@Test
	public void getConfigTest() {
		System.out.println(hello.getId());
	}
}
