package com.example.menu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.function.Consumer;

@Route(value = "/person")
public class PersonGridView extends VerticalLayout {



    public PersonGridView() {
        // Create a Grid for Person class
        Grid<Person> grid = new Grid<>(Person.class, false);

        // Add columns to the grid
        Grid.Column<Person> nameColumn = grid.addColumn(Person::getFullName)
                .setHeader("Name")
                .setWidth("230px")
                .setFlexGrow(0);
        Grid.Column<Person> emailColumn = grid.addColumn(Person::getEmail)
                .setHeader("Email");
        Grid.Column<Person> professionColumn = grid.addColumn(Person::getProfession)
                .setHeader("Profession");

        // Fetch list of people from the data service
        List<Person> people = DataService.getPeople();
        GridListDataView<Person> dataView = grid.setItems(people);

        // Create a PersonFilter for filtering data
        PersonFilter personFilter = new PersonFilter(dataView);

        // Clear existing header rows and add a new one
        grid.getHeaderRows().clear();
        HeaderRow headerRow = grid.appendHeaderRow();

        // Set up filter headers for each column
        headerRow.getCell(nameColumn).setComponent(
                createFilterHeader("Name", personFilter::setFullName));
        headerRow.getCell(emailColumn).setComponent(
                createFilterHeader("Email", personFilter::setEmail));
        headerRow.getCell(professionColumn).setComponent(
                createFilterHeader("Profession", personFilter::setProfession));

        // Add the grid to the layout
        add(grid);
    }

    // Function to create filter headers for grid columns
    private static Component createFilterHeader(String labelText,
                                                Consumer<String> filterChangeConsumer) {
        NativeLabel label = new NativeLabel(labelText);
        label.getStyle().set("padding-top", "var(--lumo-space-m)")
                .set("font-size", "var(--lumo-font-size-xs)");

        TextField textField = new TextField();
        textField.setValueChangeMode(ValueChangeMode.EAGER);
        textField.setClearButtonVisible(true);
        textField.addThemeVariants(TextFieldVariant.LUMO_SMALL);
        textField.setWidthFull();
        textField.getStyle().set("max-width", "100%");

        textField.addValueChangeListener(
                e -> filterChangeConsumer.accept(e.getValue()));

        VerticalLayout layout = new VerticalLayout(label, textField);
        layout.getThemeList().clear();
        layout.getThemeList().add("spacing-xs");

        return layout;
    }

    // Inner class for filtering person data
    private static class PersonFilter {
        private final GridListDataView<Person> dataView;

        private String fullName;
        private String email;
        private String profession;

        public PersonFilter(GridListDataView<Person> dataView) {
            this.dataView = dataView;
            this.dataView.addFilter(this::test);
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
            this.dataView.refreshAll();
        }

        public void setEmail(String email) {
            this.email = email;
            this.dataView.refreshAll();
        }

        public void setProfession(String profession) {
            this.profession = profession;
            this.dataView.refreshAll();
        }

        public boolean test(Person person) {
            boolean matchesFullName = matches(person.getFullName(), fullName);
            boolean matchesEmail = matches(person.getEmail(), email);
            boolean matchesProfession = matches(person.getProfession(), profession);

            return matchesFullName && matchesEmail && matchesProfession;
        }

        private boolean matches(String value, String searchTerm) {
            return searchTerm == null || searchTerm.isEmpty()
                    || value.toLowerCase().contains(searchTerm.toLowerCase());
        }
    }
}
