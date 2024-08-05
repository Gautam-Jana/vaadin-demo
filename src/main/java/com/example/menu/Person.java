package com.example.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Person {

    private String fullName;
    private String email;
    private String profession;

    public Person(String fullName, String email, String profession) {
        this.fullName = fullName;
        this.email = email;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
