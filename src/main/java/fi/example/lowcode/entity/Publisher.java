package fi.example.lowcode.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
@AuditOverride(forClass = Auditable.class)
public class Publisher extends Auditable {

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

}
