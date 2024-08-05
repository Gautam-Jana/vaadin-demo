package com.example.menu;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "contact", layout = Menu.class)
public class ContactView extends Div {
    public ContactView() {

        setText("This is the Contact page!");
    }
}
