package com.example.menu;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route(value = "menu")
public class Menu extends AppLayout {

    public Menu() {
        // Drawer toggle button
        DrawerToggle toggle = new DrawerToggle();

        // Set the navigation links for the side menu
        VerticalLayout sideMenu = new VerticalLayout();
        sideMenu.add(new RouterLink("Home", HomeView.class));
        sideMenu.add(new RouterLink("About", AboutView.class));
        sideMenu.add(new RouterLink("Login", PersonalDetailsView.class));
       // sideMenu.add(new RouterLink("Flights", MainView.class));
        sideMenu.add(new RouterLink("Contact", ContactView.class));

        // Set a header for the drawer
        Span drawerHeader = new Span("My App Menu");
        drawerHeader.setClassName("vector-header");

        // Add the toggle button and header to the drawer
        addToNavbar(toggle, new Span("Indigo"));

        // Add the menu items to the drawer
        addToDrawer(drawerHeader, sideMenu);

        // Set the content of the main view
        // Assuming HomeView is your main view
        setContent(new HomeView());
    }
}

