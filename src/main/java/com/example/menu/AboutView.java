package com.example.menu;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "about", layout = Menu.class)
public class AboutView extends Div {
    public AboutView() {

        setText("This is the About page!");
    }
}
