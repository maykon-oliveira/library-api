package com.github.maykonoliveira.libraryapi.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDto {
  private Long id;
  private String title;
  private String isbn;
}
