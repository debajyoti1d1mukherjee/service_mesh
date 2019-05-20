package com.openshift.microprofile.business_service.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public class GreetingResource {

	@GET
	@Path("/bs/greeting")
	@Produces("application/json")

	public String getGreeting() {

		System.out.println("getGreeting invoked------------------------------");
		for (int i = 0; i < 10; i++) {
			//load();
			//mySlowFunction(8);
			System.out.println("Business Service");
		}
		return "Hello";

	}

	private void load() {
		MyThread myThread = new MyThread();
		for (int i = 0; i <= 10; i++) {
			Thread t1 = new Thread(myThread);
			System.out.println("Thread id:::" + t1.getId());
			t1.start();
		}
	}
	
	
	private void  mySlowFunction(long number) {
		long result = 0;	
		for (double i = Math.pow(number, 7); i >= 0; i--) {		
			result += Math.atan(i) * Math.tan(i);
		};
		
	}

}
