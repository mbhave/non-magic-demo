package config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

public class MagicPropertiesPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment,
			SpringApplication application) {
		ClassPathResource resource = new ClassPathResource("magic.properties");
		if (resource.exists()) {
			PropertySource<?> source = getPropertySource(resource);
			environment.getPropertySources().addLast(source);
		}
	}

	private PropertySource<?> getPropertySource(ClassPathResource resource) {
		try {
			Properties properties = new Properties();
			properties.load(resource.getInputStream());
			return new PropertiesPropertySource("magic", properties);
		}
		catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

}
