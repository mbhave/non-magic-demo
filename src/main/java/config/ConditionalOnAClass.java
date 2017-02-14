package config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Conditional;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnAClassCondition.class)
public @interface ConditionalOnAClass {

	String className();

}
