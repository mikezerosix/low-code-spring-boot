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
class PublisherRepositoryTest {
    private static final String NEW_BODY = """
               {
               "name": "name",
               "vat": "1234567-9"
            }""";
    public static final String ENTITIES = "publishers";

    @Autowired
    private MockMvc mvc;

    @Test
    void createPublisher() throws Exception {
        expectPostCreated(mvc, ENTITIES, NEW_BODY).andExpect(jsonPath("$.name", is("name")));
    }

    @Test
    @Sql("data/createPublisher100.sql")
    void testFindAll() throws Exception {
        expectGetOKSize(mvc, ENTITIES, 1);
    }

}