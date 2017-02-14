package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnAClass(className = "org.apache.catalina.startup.Tomcat")
public class TomcatConfiguration {

	@Value("${port:8080}")
	private int port;

	@Bean
	TomcatServletWebServerFactory servletContainerFactory() {
		return new TomcatServletWebServerFactory(this.port);
	}

}
