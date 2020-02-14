package com.github.maykonoliveira.libraryapi.repository;

import com.github.maykonoliveira.libraryapi.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {}
