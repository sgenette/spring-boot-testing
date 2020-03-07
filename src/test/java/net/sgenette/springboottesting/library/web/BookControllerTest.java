package net.sgenette.springboottesting.library.web;

import net.sgenette.springboottesting.library.mapper.BookDTOMapper;
import net.sgenette.springboottesting.library.mapper.BookDTOMapperImpl;
import net.sgenette.springboottesting.library.mapper.Isbn13Mapper;
import net.sgenette.springboottesting.library.mapper.NameMapper;
import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static net.sgenette.springboottesting.library.model.data.BookData.CLEAN_CODE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @TestConfiguration
    static class BookDTOMapperImplTestContextConfiguration {

        @Bean
        public BookDTOMapper bookDTOMapperImpl() {
            return new BookDTOMapperImpl(new NameMapper(), new Isbn13Mapper());
        }
    }

    @MockBean
    private BookService bookService;

    @Test
    public void books_shouldReturnOneBook() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(CLEAN_CODE);

        when(bookService.getAllBooks()).thenReturn(books);

        mvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].isbn", is("9781861978769")))
                .andExpect(jsonPath("$[0].title", is("Clean code")))
                .andExpect(jsonPath("$[0].author.firstName", is("Robert")))
                .andExpect(jsonPath("$[0].author.lastName", is("Martin")));
    }
}
