package com.test.portal.server.application;

import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot.
 *
 * @author Aliaksei Labotski.
 * @since 2/3/18.
 */
@SpringBootApplication(scanBasePackages = "com.test.portal.server")
public class PortalApplication {

  public static void main(String[] args) {
    setSystemProperties(args);
    SpringApplication.run(PortalApplication.class, args);
  }

  private static void setSystemProperties(String[] args) {
    Stream.of(args)
        .filter(arg -> arg.contains("="))
        .map(arg -> arg.replaceFirst("--", ""))
        .map(arg -> arg.split("="))
        .filter(kv -> kv.length == 2)
        .forEach(kv -> System.setProperty(kv[0], kv[1]));
  }
}
