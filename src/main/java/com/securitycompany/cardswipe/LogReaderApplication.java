package com.securitycompany.cardswipe;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.securitycompany.cardswipe.resources.LogReaderResource

public class LogReaderApplication extends Application<LogReaderConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LogReaderApplication().run(args);
    }

    @Override
    public String getName() {
        return "LogReader";
    }

    @Override
    public void initialize(final Bootstrap<LogReaderConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final LogReaderConfiguration configuration,
                    final Environment environment) {
        final LogReaderResource resource = new LogReaderResource();
        environment.jersey().register(resource);
    }

}
