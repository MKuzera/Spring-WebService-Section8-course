package com.javacourse.section8.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javacourse.section8.Posts.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Entity(name="UserName")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("first_name")
    @NotBlank(message = "Name can't be blank")
    @Size(min=4,max=31, message = "Name must be between 4 and 31 characters")
    private String name;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> postList;
    @NotBlank(message = "Surname can't be blank")
    @Size(min=4,max=31, message = "Surname must be between 4 and 31 characters")
    private String surname;

    @PastOrPresent(message = "Date can't be from future")
    @NotNull(message = "Date can't be null")
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public User() {
    }

    public User(Integer id, String name, String surname, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
}
