package com.openshift.microprofile.bff;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Resource entry point
 */
@ApplicationPath("/bff")


public class ApplicationConfig extends Application {
    public static final AtomicBoolean IS_ALIVE = new AtomicBoolean(true);
}


