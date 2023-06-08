package fi.example.lowcode.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
        @Index(name = "ix_book_title", columnList = "title")})
public class Book {

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