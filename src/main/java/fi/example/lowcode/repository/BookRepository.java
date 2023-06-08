package fi.example.lowcode.repository;

import fi.example.lowcode.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@Transactional
public interface BookRepository extends
        CrudRepository<Book, Long>,
        RevisionRepository<Book, Long, Long> {}