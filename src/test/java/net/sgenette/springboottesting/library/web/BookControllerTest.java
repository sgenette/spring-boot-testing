package net.sgenette.springboottesting.library.web;

import net.sgenette.springboottesting.library.model.Author;
import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.model.Isbn13;
import net.sgenette.springboottesting.library.model.Name;
import net.sgenette.springboottesting.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void books() throws Exception {
        Book aBook = Book.builder().
                isbn13(new Isbn13("978 1 86197 876 9")).
                title("Clean code").
                author(Author.builder().
                        firstName(new Name("Robert")).
                        lastName(new Name("Martin")).
                        build()).
                build();
        List<Book> books = Arrays.asList(aBook);

        Mockito.when(bookService.getAllBooks()).thenReturn(books);

        mvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].isbn13.isbn13", is(aBook.getIsbn13().getIsbn13())));
    }
}
