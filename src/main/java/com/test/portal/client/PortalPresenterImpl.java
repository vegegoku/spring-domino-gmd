package com.test.portal.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import java.util.logging.Logger;

@Presenter
public class PortalPresenterImpl extends BaseClientPresenter<PortalView> implements PortalPresenter, PortalView.PortalUiHandler {

  private static final Logger LOGGER = Logger.getLogger(PortalPresenterImpl.class.getName());

  @Override
  public void initView(PortalView view) {
      view.setUiHandlers(this);
  }

  @Override
  public void contributeToMainModule(MainContext context) {
    view.reveal();
  }

  @Override
  public void onSendMessage() {
    if (view.hasEmptyMessage()) {

      String url = "/PortalService";
      boolean superDevMode = System.getProperty("superdevmode")
          .equals("on");
      if (superDevMode) {
        url = "http://localhost:8080" + url;
      }

      RequestBuilder sendRequest = new RequestBuilder(RequestBuilder.POST, url);
      sendRequest.setHeader("Content-type", "text/plain");
      sendRequest.setHeader("accept", "text/plain");
      try {
        sendRequest.sendRequest("Hello, World!", new RequestCallback() {
          @Override
          public void onResponseReceived(Request request, Response response) {
            view.showMessage(response.getText());
          }

          @Override
          public void onError(Request request, Throwable exception) {
            view.showMessage("Failed to receive answer from server!");
          }
        });
      } catch (RequestException e) {
      }
    } else {
      view.clear();
    }
  }
}
