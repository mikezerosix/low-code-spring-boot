package fi.example.lowcode.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @NotNull
    @NotEmpty
    public String name;

    @NotNull
    @Column(unique = true)
    @Size(min = 9, max = 9)
    @Pattern(regexp = "^\\d{7}-\\d$", message = "Invalid VAT format")
    public String vat;

    public URL url;

    @OneToMany(mappedBy = "publisher")
    public Set<Author> authors = new HashSet<>();

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
