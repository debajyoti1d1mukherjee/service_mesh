package com.openshift.microprofile.bff.resource;

import java.net.MalformedURLException;
import java.net.URL;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;



@ApplicationScoped
@Path("/")
public class GreetingBFFRestController {
   private GreetingResource businessServiceClient;

	@GET
	@Path("/discover/env")
	@Produces("application/json")
	public String getGreetingbyEnvVariables() throws MalformedURLException, ProcessingException, UnknownUrlException  {

		System.out.println("getGreetingbyEnvVariables invoked------------------------------");
		String host = System.getenv("BUSINESS_SERVICE_SERVICE_HOST");
		String port = System.getenv("BUSINESS_SERVICE_SERVICE_PORT");
		String baseUrl = "http://"+host+":"+port+"/api";
		System.out.println("baseURL==="+baseUrl);
		URL customURL =  new URL(baseUrl);
		GreetingResource customRestClient = RestClientBuilder.newBuilder()
                .baseUrl(customURL)
                .register(UnknownUrlExceptionMapper.class)
                .build(GreetingResource.class);

		return customRestClient.getGreeting();
	}
	
	
	@GET
	@Path("/discover/dns")
	@Produces("application/json")
	public String getGreetingbyKubeDNS() throws MalformedURLException, ProcessingException, UnknownUrlException  {

		System.out.println("getGreetingbyKubeDNS invoked now------------------------------");
		// baseUrlDns = "http://business-service.default.svc.cluster.local:8080/api";
		String baseUrlDns = "http://business-service:8080/api";
		System.out.println("baseUrlDns==="+baseUrlDns);
		URL customURL =  new URL(baseUrlDns);
		GreetingResource customRestClient = RestClientBuilder.newBuilder()
                .baseUrl(customURL)
                .register(UnknownUrlExceptionMapper.class)
                .build(GreetingResource.class);

		return customRestClient.getGreeting();
	}
	
	@GET
	@Path("/test")
	@Produces("application/json")
	public String test() throws MalformedURLException, ProcessingException{
		System.out.println("test invoked------------------------------");
		return "test";

	}

}
