package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class Application {

	@Bean
	TomcatServletWebServerFactory servletContainerFactory() {
		return new TomcatServletWebServerFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@RestController
	class HelloController {

		@RequestMapping("/")
		public String hello() {
			return "hello world";
		}

	}

}
