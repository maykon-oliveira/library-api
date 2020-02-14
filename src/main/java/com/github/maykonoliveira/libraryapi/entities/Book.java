package com.github.maykonoliveira.libraryapi.entities;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  private Long id;
  private String title;
  private String isbn;
}
