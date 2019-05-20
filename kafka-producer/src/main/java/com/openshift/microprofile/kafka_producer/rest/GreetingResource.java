package com.openshift.microprofile.kafka_producer.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RecordMetadata;

import net.wessendorf.kafka.SimpleKafkaProducer;
import net.wessendorf.kafka.cdi.annotation.KafkaConfig;
import net.wessendorf.kafka.cdi.annotation.Producer;



@Path("/")
//@KafkaConfig(bootstrapServers = "#{MY_CLUSTER_KAFKA_0_SERVICE_HOST}:#{MY_CLUSTER_KAFKA_0_SERVICE_PORT}")
@KafkaConfig(bootstrapServers = "172.30.7.196:9092")
public class GreetingResource {
	
	@Producer
	private SimpleKafkaProducer<String, String> myproducer;

	@GET
	@Path("/bs/greeting")
	@Produces("application/json")
	public String getGreeting() throws InterruptedException, ExecutionException {
		

		System.out.println("getGreeting invoked------------------------------");
		Future<RecordMetadata> future  = myproducer.send("my-topic", "test-key", "test-value");
		System.out.println("message dropped to queue------------------------------");
		RecordMetadata recordMetadata = future.get();
		System.out.println("partition::::"+recordMetadata.partition());
		System.out.println("offset::::"+recordMetadata.offset());
		return "Hello";

	}



}
