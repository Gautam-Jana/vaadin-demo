package com.example.mainlayout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
    }

    private void createHeader() {
        HorizontalLayout header = new HorizontalLayout();

        Button homeButton = new Button("Home", new Icon(VaadinIcon.HOME));
        homeButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("home")));

        Button myAppButton = new Button("My App", new Icon(VaadinIcon.ADJUST));
        myAppButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("app")));

        header.add(homeButton, myAppButton);
        addToNavbar(header);
    }
}
