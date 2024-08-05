package com.example.menu;

import java.util.Arrays;
import java.util.List;

public class DataService {

    // Singleton pattern for DataService
    private static DataService instance;

    private DataService() {
        // Private constructor to prevent instantiation
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    // Method to fetch list of Person objects
    public static List<Person> getPeople() {

        // Simulated data source
        return Arrays.asList(
                new Person("Alice Smith", "alice@example.com", "Engineer"),
                new Person("Bob Johnson", "bob@example.com", "Designer"),
                new Person("Carol Williams", "carol@example.com", "Manager"),
                new Person("David Brown", "david@example.com", "Developer"),
                new Person("Eve Davis", "eve@example.com", "Architect"),
                Person.builder().email("shashank@gmail.com").build()
        );
    }
}
