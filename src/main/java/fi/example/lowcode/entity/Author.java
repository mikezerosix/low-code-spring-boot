package fi.example.lowcode.entity;

import jakarta.persistence.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
@AuditOverride(forClass = Auditable.class)
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String firstname;

    public String lastname;

    @ManyToOne
    public Publisher publisher;

    @OneToMany(mappedBy = "author")
    public Set<Book> books = new HashSet<>();

}