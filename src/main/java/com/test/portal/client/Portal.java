package com.test.portal.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Portal implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final Button button = new Button("Click me");
    final Label label = new Label();

    button.addClickHandler(event -> {
      if (label.getText()
          .equals("")) {

        String url = "/PortalService";
        boolean superDevMode = System.getProperty("superdevmode")
            .equals("on");
        if (superDevMode) {
          url = "http://localhost:8080" + url;
        }

        RequestBuilder sendRequest = new RequestBuilder(RequestBuilder.POST, url);
        sendRequest.setHeader( "Content-type", "text/plain" );
        sendRequest.setHeader( "accept", "text/plain" );
        try {
          sendRequest.sendRequest("Hello, World!", new RequestCallback() {
            @Override
            public void onResponseReceived(Request request, Response response) {
              label.setText(response.getText());
            }

            @Override
            public void onError(Request request, Throwable exception) {
              label.setText("Failed to receive answer from server!");
            }
          });
        } catch (RequestException e) {
        }
      } else {
        label.setText("");
      }
    });

    // Assume that the host HTML has elements defined whose
    // IDs are "slot1", "slot2".  In a real app, you probably would not want
    // to hard-code IDs.  Instead, you could, for example, search for all
    // elements with a particular CSS class and replace them with widgets.
    //
    RootPanel.get("slot1")
        .add(button);
    RootPanel.get("slot2")
        .add(label);
  }

}
