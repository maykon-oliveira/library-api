package com.github.maykonoliveira.libraryapi.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.maykonoliveira.libraryapi.rest.dto.BookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class BookRestTest {
  String BOOK_API = "/api/books";
  @Autowired MockMvc mvc;

  @Test
  @DisplayName("Given a bookDto should save correctly")
  void saveBook() throws Exception {
    BookDto dto = BookDto.builder().id(1L).isbn("123").build();
    String json = new ObjectMapper().writeValueAsString(dto);

    MockHttpServletRequestBuilder request =
        MockMvcRequestBuilders.post(BOOK_API).contentType(MediaType.APPLICATION_JSON).content(json);

    mvc.perform(request)
        .andExpect(status().isCreated())
        .andExpect(jsonPath("id").isNotEmpty())
        .andExpect(jsonPath("isbn").value("123"));
  }

  @Test
  @DisplayName("Given a bookDto with errors should not save it")
  void saveInvalidBook() {}
}
