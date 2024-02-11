package com.javacourse.section8.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("password")
@JsonFilter("UserFilter")
public class UserToFilter {
private String name;
private String surname;
//@JsonIgnore
private String password;
private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserToFilter(String name, String surname, String password, String description) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.description = description;
    }
}
