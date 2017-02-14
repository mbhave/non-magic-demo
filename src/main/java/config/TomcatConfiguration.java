package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnAClass(className = "org.apache.catalina.startup.Tomcat")
public class TomcatConfiguration {

	@Value("${port:8080}")
	private int port;

	@Bean
	EmbeddedServletContainerFactory servletContainerFactory() {
		return new TomcatEmbeddedServletContainerFactory(this.port);
	}

}
