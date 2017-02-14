package config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@Configuration
@Conditional(TomcatConfiguration.OnTomcatCondition.class)
public class TomcatConfiguration {

	@Bean
	TomcatServletWebServerFactory servletContainerFactory() {
		return new TomcatServletWebServerFactory();
	}

	static class OnTomcatCondition implements Condition {

		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",
					context.getClassLoader());
		}

	}

}
