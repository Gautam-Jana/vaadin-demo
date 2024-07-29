package com.example;


import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(value = "mythemes", variant = Lumo.DARK)
public class VaadinDemoApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(VaadinDemoApplication.class, args);
    }
}

