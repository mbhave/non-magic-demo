package config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnAClass(className = "org.apache.catalina.startup.Tomcat")
public class TomcatConfiguration {

	private final ServerProperties properties;

	public TomcatConfiguration(ServerProperties properties) {
		this.properties = properties;
	}

	@Bean
	EmbeddedServletContainerFactory servletContainerFactory() {
		return new TomcatEmbeddedServletContainerFactory(this.properties.getPort());
	}

}
