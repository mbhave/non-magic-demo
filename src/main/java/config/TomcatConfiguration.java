package config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MagicConfiguration
@ConditionalOnAClass(className = "org.apache.catalina.startup.Tomcat")
public class TomcatConfiguration {

	@Bean
	TomcatServletWebServerFactory servletContainerFactory() {
		return new TomcatServletWebServerFactory();
	}

}
