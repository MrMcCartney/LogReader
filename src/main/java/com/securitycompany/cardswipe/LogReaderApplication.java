package com.securitycompany.cardswipe;

import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import java.util.EnumSet;

import com.securitycompany.cardswipe.resources.LogReaderResource;
import com.securitycompany.cardswipe.dao.LogDAO;

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
        bootstrap.addBundle(new Java8Bundle());
    }

    @Override
    public void run(final LogReaderConfiguration configuration, final Environment environment) 
    throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final LogDAO logDAO = jdbi.onDemand(LogDAO.class);

        final LogReaderResource resource = new LogReaderResource(logDAO);
        environment.jersey().register(resource);
        
        configureCors(environment);
	}

    private void configureCors(Environment environment) {
        Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }
}
