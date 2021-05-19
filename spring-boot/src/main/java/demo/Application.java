package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.setWebApplicationType(WebApplicationType.NONE);
//		springApplication.run(args);
		SpringApplication.run(Application.class, args);
	}

}
