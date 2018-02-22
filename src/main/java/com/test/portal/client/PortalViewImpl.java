package com.test.portal.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.progressoft.brix.domino.api.client.annotations.UiView;

@UiView(presentable = PortalPresenter.class)
public class PortalViewImpl implements PortalView{

  final Button button = new Button("Click me");
  final Label label = new Label();

  private PortalUiHandler uiHandlers;

  @Override public void reveal() {
    RootPanel.get("slot1")
        .add(button);
    RootPanel.get("slot2")
        .add(label);

    button.addClickHandler(event -> {
      uiHandlers.onSendMessage();
    });
  }

  @Override
  public void setUiHandlers(PortalUiHandler uiHandlers) {
    this.uiHandlers=uiHandlers;
  }

  @Override
  public boolean hasEmptyMessage() {
    return label.getText().isEmpty();
  }

  @Override
  public void showMessage(String message) {
    label.setText(message);
  }

  @Override
  public void clear() {
    label.setText("");
  }
}
