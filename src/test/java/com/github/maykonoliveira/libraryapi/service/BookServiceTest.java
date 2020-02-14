package com.github.maykonoliveira.libraryapi.service;

import com.github.maykonoliveira.libraryapi.entities.Book;
import com.github.maykonoliveira.libraryapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class BookServiceTest {

  BookService bookService;
  @MockBean BookRepository bookRepository;

  @BeforeEach
  void setup() {
    bookService = new BookService(bookRepository);
  }

  @Test
  void save() {
    Book book = Book.builder().isbn("123").build();

    Mockito.when(bookRepository.save(book)).thenReturn(Book.builder().id(1L).isbn("123").build());

    Book saved = bookService.save(book);

    Mockito.verify(bookRepository, Mockito.only()).save(book);
    assertThat(saved).isNotNull();
    assertThat(saved.getId()).isNotNull();
    assertThat(saved.getIsbn()).isEqualTo("123");
  }
}
