package example;

import config.DispatcherServletConfiguration;
import config.MvcConfiguration;
import config.TomcatConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({ TomcatConfiguration.class, DispatcherServletConfiguration.class,
		MvcConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
