package fi.example.lowcode.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static fi.example.lowcode.HateoasTestUtil.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(properties = { MEM_DB_PROPERTY })
@AutoConfigureMockMvc
@Transactional
class BookRepositoryTest {
    private static final String NEW_BODY = """
            {
              "author": "authors/101",
              "isbn": "1234567890123",
              "title": "title1"
            }""";
    public static final String ENTITIES = "books";

    @Autowired
    private MockMvc mvc;

    @Test
    @Sql("data/createPublisher100.sql")
    @Sql("data/createAuthor101.sql")
    void createAuthor() throws Exception {
        expectPostCreated(mvc, ENTITIES, NEW_BODY).andExpect(jsonPath("$.title", is("title1")));
    }

    @Test
    @Sql("data/createPublisher100.sql")
    @Sql("data/createAuthor101.sql")
    @Sql("data/createBook102.sql")
    void testFindAll() throws Exception {
        expectGetOKSize(mvc, ENTITIES, 1);
    }

}