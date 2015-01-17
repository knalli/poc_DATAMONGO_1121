package de.knallisworld.poc.config;

import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.*;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.IRuntimeConfig;
import de.flapdoodle.embed.process.config.io.ProcessOutput;
import de.flapdoodle.embed.process.extract.UserTempNaming;
import de.flapdoodle.embed.process.io.Processors;
import de.flapdoodle.embed.process.runtime.Network;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class MongoServerConfig {

	private MongodExecutable mongodExecutable;

	private int mongodPort;

	@Bean
	public Properties mongoProperties() {
		final Properties properties = new Properties();
		properties.setProperty("mongodb.database", "test");
		properties.setProperty("mongodb.port", "" + mongodPort);
		return properties;
	}

	@PostConstruct
	public void startMongo() throws IOException {

		Command command = Command.MongoD;

		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();

		final Logger logger = Logger.getLogger("mongod");
		ProcessOutput processOutput = new ProcessOutput(Processors.logTo(logger, Level.INFO), Processors.logTo(logger,
				Level.SEVERE), Processors.named("[console>]", Processors.logTo(logger, Level.FINE)));

		IRuntimeConfig runtimeConfig = new RuntimeConfigBuilder()
				.defaults(command)
				.processOutput(processOutput)
				.artifactStore(new ArtifactStoreBuilder()
						.defaults(command)
						.download(new DownloadConfigBuilder()
								.defaultsForCommand(command))
						.executableNaming(new UserTempNaming()))
				.build();


		final MongodStarter runtime = MongodStarter.getInstance(runtimeConfig);

		mongodPort = 12345;
		IMongodConfig mongodConfig = new MongodConfigBuilder()
				.version(Version.Main.PRODUCTION)
				.net(new Net(mongodPort, Network.localhostIsIPv6()))
				.build();

		mongodExecutable = null;
		try {
			mongodExecutable = runtime.prepare(mongodConfig);
			MongodProcess mongod = mongodExecutable.start();
		} finally {

		}
	}

	@PreDestroy
	public void stopMongo() {
		if (mongodExecutable != null) {
			mongodExecutable.stop();
		}
	}

}
