package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Config;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	Config config;

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.setWebApplicationType(WebApplicationType.NONE);
//		springApplication.run(args);
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(config.getId());
	}
}
