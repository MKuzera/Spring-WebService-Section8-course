package com.javacourse.section8.VersioningPerson;

public class PersonV2 {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonV2(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
