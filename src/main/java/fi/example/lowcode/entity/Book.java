package fi.example.lowcode.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditOverride(forClass = Auditable.class)
@Table(indexes = {@Index(name = "ix_book_title", columnList = "title")})
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @NotEmpty
    @Column(nullable = false)
    public String title;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Size(min = 13, max = 13)
    public String isbn;

    @ManyToOne
    public Author author;

}