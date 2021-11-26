package com.grupa5.biblioteka.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private String name;
    private String surname;

    private boolean enabled;

    private USER_ROLE user_role;

    @ManyToMany
    @JoinTable(
            name = "users_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;


    public User() {}

    public User(String login, String password, String name, String surname, boolean enabled, USER_ROLE user_role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.enabled = enabled;
        this.user_role = user_role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public USER_ROLE getUser_role() {
        return user_role;
    }

    public void setUser_role(USER_ROLE user_role) {
        this.user_role = user_role;
    }
}
