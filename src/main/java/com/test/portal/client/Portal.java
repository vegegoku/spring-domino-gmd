package com.test.portal.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ClientApp;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import java.util.logging.Logger;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
@ClientModule(name = "Portal")
public class Portal implements EntryPoint {

  private static final Logger LOGGER = Logger.getLogger(Portal.class.getName());

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    new ModuleConfigurator().configureModule(new PortalModuleConfiguration());
    ClientApp.make()
        .run();
  }

}
