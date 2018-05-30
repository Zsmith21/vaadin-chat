package com.vaadin.starter.skeleton.spring;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;

@Route("")
@StyleSheet("styles/styles.css")
public class MainView extends VerticalLayout implements PageConfigurator {


  public MainView() {
    add(new H1("Hello world"));
  }


  @Override
  public void configurePage(InitialPageSettings settings) {
    settings.addLink(InitialPageSettings.Position.PREPEND, "manifest", "manifest.webmanifest");
    settings.addLink(InitialPageSettings.Position.PREPEND, "icon", "favicon.png");
    settings.addInlineWithContents(
        "window.addEventListener('load', function() { " +
            "  if('serviceWorker' in navigator) {" +
            "    navigator.serviceWorker.register('./sw.js');" +
            "  }" +
            "});", InitialPageSettings.WrapMode.JAVASCRIPT);
  }

}
