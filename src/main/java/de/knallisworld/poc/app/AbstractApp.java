package de.knallisworld.poc.app;

import java.io.IOException;

import de.knallisworld.poc.mongo.model.Envelope;
import de.knallisworld.poc.mongo.repository.ActivityRepository;
import org.springframework.context.ConfigurableApplicationContext;

abstract public class AbstractApp {

	public void start() throws IOException {

		ConfigurableApplicationContext context = createContext();

		context.refresh();
		context.start();

		ActivityRepository activityRepository = context.getBean(ActivityRepository.class);

		Envelope envelope = new Envelope();
		activityRepository.save(envelope);

		//activityRepository.findAll().forEach(System.out::println);
	}

	abstract protected ConfigurableApplicationContext createContext();

}
