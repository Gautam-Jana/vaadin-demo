package com.example.menu;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "flights",layout=Menu.class)
public class MainView extends HorizontalLayout {

    public MainView() {
        setSizeFull();
        setClassName("main-layout");

        add(createCard("MSMI Media UX Award", "2018-19", "Toronto, Canada", "12 Oct 2019", "Winner"));
        add(createCard("Apple Design Award", "2018-19", "United States", "28 Dec 2019", "Gold Winner"));
        add(createCard("Yellow Dot Design Award", "2019-20", "United Nations", "28 Nov 2019", "Asia Pacific"));
        add(createCard("Indiana's Best Design", "2019-20", "North America", "28 Nov 2019", "Runner up"));
        add(createCard("UMO UX India Award", "2020-21", "Hyderabad, India", "30 Dec 2019", "Silver Winner"));
        add(createCard("Best Music Album", "2018-19", "Mumbai, India", "13 Aug 2019", "Winner"));
    }

    private VerticalLayout createCard(String title, String year, String location, String date, String award) {
        VerticalLayout card = new VerticalLayout();
        card.addClassName("card");

        Image image = new Image("Indigo.webp","Indigo");
        image.addClassName("card-image");

        Span cardTitle = new Span(title);
        cardTitle.addClassName("card-title");

        Paragraph cardYear = new Paragraph(year);
        cardYear.addClassName("card-year");

        Paragraph cardLocation = new Paragraph(location);
        cardLocation.addClassName("card-location");

        Span cardDate = new Span(date);
        cardDate.addClassName("card-date");

        Span cardAward = new Span(award);
        cardAward.addClassName("card-award");

        card.add(image, cardDate, cardAward, cardTitle, cardYear, cardLocation);
        return card;
    }
}
