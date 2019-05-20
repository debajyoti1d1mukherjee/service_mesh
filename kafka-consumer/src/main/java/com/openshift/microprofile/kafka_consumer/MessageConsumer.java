package com.openshift.microprofile.kafka_consumer;

import javax.enterprise.context.ApplicationScoped;

import net.wessendorf.kafka.cdi.annotation.Consumer;
import net.wessendorf.kafka.cdi.annotation.KafkaConfig;

@ApplicationScoped
@KafkaConfig(bootstrapServers = "172.30.7.196:9092")
public class MessageConsumer {
	
	@Consumer(topics = "my-topic", keyType = String.class,groupId = "test-group")
	public void processMessage(final String  key, final String value) {
	  System.out.println("key============"+key+"value=========="+value);
	}

}
