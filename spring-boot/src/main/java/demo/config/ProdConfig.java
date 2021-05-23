package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import demo.domain.Config;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
@Profile("prod")
@Configuration
public class ProdConfig {
	@Bean
	public Config hello() {
		return new Config("prodConfig");
	}
}
