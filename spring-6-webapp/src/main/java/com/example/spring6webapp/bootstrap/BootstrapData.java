package com.example.spring6webapp.bootstrap;

import com.example.spring6webapp.domain.Author;
import com.example.spring6webapp.domain.Book;
import com.example.spring6webapp.domain.Publisher;
import com.example.spring6webapp.repositories.AuthorRepository;
import com.example.spring6webapp.repositories.BookRepository;
import com.example.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Publisher> publishers = new ArrayList<>();

        IntStream.range(0, 5).forEachOrdered(n -> {
            // author
            Author newAuthor = new Author();
            newAuthor.setLastName("Ta");
            newAuthor.setFirstName("Son " + n);
            authors.add(authorRepository.save(newAuthor));

            // book
            Book newBook = new Book();
            newBook.setTitle("Quyen sach thu " + n);
            newBook.setIsbn("12345" + n);
            books.add(bookRepository.save(newBook));

            // publisher
            Publisher newPublisher = new Publisher();
            newPublisher.setPublisherName("Son " + n);
            newPublisher.setAddress("Dia Chi" + n);
            publishers.add(publisherRepository.save(newPublisher));
        });

        // set book for author
        IntStream.range(0, authors.size()).forEachOrdered(i -> {
            authors.get(i).setBooks(Set.of(books.get(i)));
            publishers.get(i).setBooks(Set.of(books.get(i)));
            books.get(i).setAuthors(Set.of(authors.get(i)));
            books.get(i).setPublisher(publishers.get(i));
        });
        authorRepository.saveAll(authors);
        bookRepository.saveAll(books);
        publisherRepository.saveAll(publishers);
    }
}
