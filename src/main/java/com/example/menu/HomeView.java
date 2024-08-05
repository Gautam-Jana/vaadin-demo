package com.example.menu;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = Menu.class)
public class HomeView extends Div {
    public HomeView() {
        setText("Welcome to the Home page!");
    }
}

