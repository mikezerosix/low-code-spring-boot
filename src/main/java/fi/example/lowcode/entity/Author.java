package fi.example.lowcode.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String firstName;

    public String lastName;

}
