package fi.example.lowcode;

import fi.example.lowcode.entity.Author;
import fi.example.lowcode.entity.Book;
import fi.example.lowcode.entity.Publisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Publisher.class, Author.class, Book.class);
        //TODO: tighten security for production
        cors.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "PATCH", "PUT", "POST", "OPTIONS", "DELETE")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Accept", "Authorization")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(false);
    }

}