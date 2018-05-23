package com.vaadin.starter.skeleton.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;

@Route("")
public class MainView extends VerticalLayout implements PageConfigurator {

  public MainView() {
    var button = new Button("Click me");
    button.addClickListener(click -> add(new Span("You Clicked!")));
    add(button);
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
