package ca.thacker.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by AndreaThacker on 2/18/2016.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(RepositoryRestMvcConfiguration.class)
public class ProjectDataTestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProjectDataRestApplication.class, args);
    }
}
