package com.example.homeview;


import com.example.mainlayout.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new H1("Welcome to the Home Page!"));
    }
}
