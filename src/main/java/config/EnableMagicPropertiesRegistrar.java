package config;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

class EnableMagicPropertiesRegistrar
		implements ImportBeanDefinitionRegistrar, EnvironmentAware {

	private ConfigurableEnvironment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = (ConfigurableEnvironment) environment;
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata,
			BeanDefinitionRegistry registry) {
		ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) registry;
		Map<String, Object> attributes = metadata
				.getAnnotationAttributes(EnableMagicProperties.class.getName());
		Class<?> type = (Class<?>) attributes.get("value");
		beanFactory.registerSingleton(type.getName(), createAndBind(type));
	}

	private Object createAndBind(Class<?> type) {
		Binder binder = Binder.get(this.environment);
		BindResult<?> bindResult = binder.bind("", type);
		if (bindResult.isBound()) {
			return bindResult.get();
		}
		return BeanUtils.instantiateClass(type);
	}

}
