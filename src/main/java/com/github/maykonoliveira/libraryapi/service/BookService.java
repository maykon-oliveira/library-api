package com.github.maykonoliveira.libraryapi.service;

import com.github.maykonoliveira.libraryapi.entities.Book;
import com.github.maykonoliveira.libraryapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
  private final BookRepository bookRepository;

  public Book save(Book book) {
    return bookRepository.save(book);
  }
}
