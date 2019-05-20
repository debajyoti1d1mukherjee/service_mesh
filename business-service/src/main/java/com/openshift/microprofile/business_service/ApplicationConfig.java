package com.openshift.microprofile.business_service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Resource entry point
 */
@ApplicationPath("/api")


public class ApplicationConfig extends Application {
    public static final AtomicBoolean IS_ALIVE = new AtomicBoolean(true);
}


