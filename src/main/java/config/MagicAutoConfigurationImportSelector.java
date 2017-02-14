package config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MagicAutoConfigurationImportSelector implements DeferredImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] { "config.TomcatConfiguration",
				"config.DispatcherServletConfiguration", "config.MvcConfiguration" };
	}

}
