package com.github.maykonoliveira.libraryapi.rest;

import com.github.maykonoliveira.libraryapi.entities.Book;
import com.github.maykonoliveira.libraryapi.rest.dto.BookDto;
import com.github.maykonoliveira.libraryapi.service.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookRest {

  private final BookService bookService;
  private final ModelMapper mapper;

  @PostMapping
  public ResponseEntity createBook(@RequestBody BookDto dto) {
    Book book = mapper.map(dto, Book.class);
    book = bookService.save(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(book);
  }
}
