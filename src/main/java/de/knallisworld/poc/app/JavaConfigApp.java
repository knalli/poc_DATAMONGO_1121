package de.knallisworld.poc.app;

import de.knallisworld.poc.config.MongoClientJavaConfig;
import de.knallisworld.poc.config.MongoServerConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp extends AbstractApp {
	@Override
	protected ConfigurableApplicationContext createContext() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MongoServerConfig.class, MongoClientJavaConfig.class);
		context.setDisplayName("Proof Of Concept DATAMONGO-1121 (JavaConfig)");
		return context;
	}
}
