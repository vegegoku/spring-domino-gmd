package com.test.portal.client;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;

public interface PortalPresenter extends Presentable{

  @InjectContext(extensionPoint=MainExtensionPoint.class)
  void contributeToMainModule(MainContext context);

}
