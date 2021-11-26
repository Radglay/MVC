package com.grupa5.biblioteka.model;


//import javax.persistence.*;
import javax.persistence.*;
import java.util.Set;



@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private String type;

    @ManyToMany(mappedBy = "books")
    private Set<User> users;

    public Book() {}

    public Book(String name, String author, String type) {
        this.name = name;
        this.author = author;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
