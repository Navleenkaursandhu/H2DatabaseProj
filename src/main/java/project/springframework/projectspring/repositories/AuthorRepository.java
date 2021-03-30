package project.springframework.projectspring.repositories;

import org.springframework.data.repository.CrudRepository;
import project.springframework.projectspring.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
