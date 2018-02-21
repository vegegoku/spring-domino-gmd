package com.test.portal.server.config;

import com.test.portal.server.servlet.PortalServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Servlet configuration.
 *
 * @author Aliaksei Labotski.
 * @since 2/6/18.
 */
@Configuration
public class ServletConfig {

  @Bean
  public ServletRegistrationBean portalServlet() {
    ServletRegistrationBean registration = new ServletRegistrationBean(new PortalServlet(), "/PortalService/*");
    registration.setName(PortalServlet.class.getSimpleName());
    return registration;
  }

}
