package config;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UndertowConfiguration {

	@Bean
	public UndertowServletWebServerFactory undertowContainerFactory() {
		return new UndertowServletWebServerFactory();
	}

}
