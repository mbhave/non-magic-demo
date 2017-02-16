package config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Import(EnableMagicPropertiesRegistrar.class)
public @interface EnableMagicProperties {

	Class<?> value();

}
