package com.sbm.jms;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsServiceApplication {

	public static void main(String[] args) throws Exception {
		// start a new active mq server
		ActiveMQServer activeMQServer = ActiveMQServers.newActiveMQServer(
				new ConfigurationImpl()
						.setPersistenceEnabled(false)
						.setJournalDirectory("target/data/journal")
						.setSecurityEnabled(false)
						.addAcceptorConfiguration("invm", "vm://0")
		);
		activeMQServer.start();
		// end of starting new active mq server
		SpringApplication.run(JmsServiceApplication.class, args);
	}

}
