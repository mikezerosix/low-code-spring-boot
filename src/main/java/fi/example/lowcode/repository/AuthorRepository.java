package fi.example.lowcode.repository;

import fi.example.lowcode.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorRepository extends CrudRepository<Author, Long> {}