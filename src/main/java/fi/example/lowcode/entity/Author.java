package fi.example.lowcode.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String firstname;

    public String lastname;

    @ManyToOne
    public Publisher publisher;

    @OneToMany(mappedBy = "author")
    public Set<Book> books = new HashSet<>();

}
