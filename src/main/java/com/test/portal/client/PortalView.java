package com.test.portal.client;

import com.progressoft.brix.domino.api.client.mvp.view.HasUiHandlers;
import com.progressoft.brix.domino.api.client.mvp.view.UiHandlers;
import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.test.portal.client.PortalView.PortalUiHandler;

public interface PortalView extends View , HasUiHandlers<PortalUiHandler>{

  boolean hasEmptyMessage();

  void showMessage(String message);

  void clear();

  void reveal();

  interface PortalUiHandler extends UiHandlers {
    void onSendMessage();
  }

}
