package fi.example.lowcode.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Entity
@Immutable
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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
