package fi.example.lowcode.repository;

import fi.example.lowcode.entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PublisherRepository extends CrudRepository<Publisher, Long> {}
