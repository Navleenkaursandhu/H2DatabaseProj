package project.springframework.projectspring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.springframework.projectspring.domain.Author;
import project.springframework.projectspring.domain.Book;
import project.springframework.projectspring.domain.Publisher;
import project.springframework.projectspring.repositories.AuthorRepository;
import project.springframework.projectspring.repositories.BookRepository;
import project.springframework.projectspring.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Publisher obj = new Publisher();
        obj.setName("SFG Publisher");
        obj.setCity("Ottawa");
        obj.setState("ON");

        publisherRepository.save(obj);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author obj1 = new Author("Eric", "Evans");
        Book obj2 = new Book("Java: The Complete Guide", "128945");
        obj1.getBooks().add(obj2);
        obj2.getAuthors().add(obj1);

        obj2.setPublisher(obj);
        obj.getBooks().add(obj2);

        authorRepository.save(obj1);
        bookRepository.save(obj2);
        publisherRepository.save(obj);

        Author obj3 = new Author("John", "Doe");
        Book obj4 = new Book ("Spring Framework","4536342");
        obj3.getBooks().add(obj4);
        obj4.getAuthors().add(obj3);


        obj4.setPublisher(obj);
        obj.getBooks().add(obj4);

        authorRepository.save(obj3);
        bookRepository.save(obj4);
        publisherRepository.save(obj);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher no of books: " + obj.getBooks().size());
    }
}
