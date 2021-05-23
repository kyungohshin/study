package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.domain.Config;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
@Configuration
public class BaseConfig {
	@Bean
	public Config hello() {
		return new Config("baseConfig");
	}

}
