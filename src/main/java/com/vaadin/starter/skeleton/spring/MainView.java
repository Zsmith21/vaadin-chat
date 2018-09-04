package com.vaadin.starter.skeleton.spring;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@StyleSheet("styles/styles.css")
public class MainView extends VerticalLayout {

  public MainView() {
    add(new H1("Hello World!"));
  }

}
