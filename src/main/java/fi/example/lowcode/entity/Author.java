package fi.example.lowcode.entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String firstname;

    public String lastname;

    @ManyToOne
    public Publisher publisher;

    @OneToMany(mappedBy = "author")
    public Set<Book> books = new HashSet<>();

    @Version
    public long version;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    public Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    public Date modified = new Date();

    @CreatedBy
    @Column(updatable = false)
    public String creator;

    @LastModifiedBy
    public String modifier;

}