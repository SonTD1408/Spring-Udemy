package com.example.spring6webapp.bootstrap;

import com.example.spring6webapp.domain.Author;
import com.example.spring6webapp.domain.Book;
import com.example.spring6webapp.repositories.AuthorRepository;
import com.example.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Author> authors = new ArrayList<>();
        List<Book> books = new ArrayList<>();

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
        });

        IntStream.range(0, authors.size()).forEachOrdered(i -> {
            authors.get(i).getBooks().add(books.get(i));
        });
        authorRepository.saveAll(authors);
        System.out.println(authorRepository.count());
    }
}
