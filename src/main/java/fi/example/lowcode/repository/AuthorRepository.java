package fi.example.lowcode.repository;

import fi.example.lowcode.entity.Author;
import fi.example.lowcode.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long>, RevisionRepository<Author, Long, Long> {}