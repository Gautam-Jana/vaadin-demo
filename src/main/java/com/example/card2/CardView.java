package com.example.card2;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("card2")
public class CardView extends VerticalLayout {

    public CardView() {
        addClassName("card-view");
        setSpacing(false);
        setPadding(true);

        HorizontalLayout cardLayout = new HorizontalLayout();
        cardLayout.addClassName("card-layout");
        cardLayout.setSpacing(true);
        cardLayout.setPadding(true);

        cardLayout.add(
                createCard("Email", "Email Generate", "When Using Customer Journey Build Automations", "green"),
                createCard("Payment", "", "AI Writing\nAnalytics Report\nBoost Email", "yellow"),
                createStatCard("Accessby", "1.9M People", "Successful Emailed", "2M", "Active Brands", "4B", "Email Delivered", "blue")
        );

        add(cardLayout);
    }

    private Div createCard(String title, String mainText, String subText, String color) {
        Div card = new Div();
        card.addClassName("card");
        card.addClassName(color);

        H2 h2 = new H2(title);
        h2.addClassName("card-title");

        H2 mainHeader = new H2(mainText);
        mainHeader.addClassName("card-main-text");

        Paragraph p = new Paragraph(subText);
        p.addClassName("card-sub-text");

        card.add(h2, mainHeader, p);
        return card;
    }

    private Div createStatCard(String title, String stat1, String label1, String stat2, String label2, String stat3, String label3, String color) {
        Div card = new Div();
        card.addClassName("card");
        card.addClassName(color);

        H2 h2 = new H2(title);
        h2.addClassName("card-title");

        Div statLayout = new Div();
        statLayout.addClassName("stat-layout");

        statLayout.add(createStatItem(stat1, label1));
        statLayout.add(createStatItem(stat2, label2));
        statLayout.add(createStatItem(stat3, label3));

        card.add(h2, statLayout);
        return card;
    }

    private Div createStatItem(String stat, String label) {
        Div item = new Div();
        item.addClassName("stat-item");

        H2 statH2 = new H2(stat);
        statH2.addClassName("stat");

        Paragraph labelP = new Paragraph(label);
        labelP.addClassName("stat-label");

        item.add(statH2, labelP);
        return item;
    }
}

