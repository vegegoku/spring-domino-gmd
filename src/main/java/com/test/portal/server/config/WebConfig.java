package com.test.portal.server.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web configuration.
 *
 * @author Aliaksei Labotski.
 * @since 2/3/18.
 */
@Configuration
@Log4j2
public class WebConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        //         we have to enable CORS to make requests from other domains work
        registry.addMapping("/**")
            .allowedHeaders("*")
            .allowedOrigins("*")
            .allowedMethods("*");
      }
    };
  }
}
