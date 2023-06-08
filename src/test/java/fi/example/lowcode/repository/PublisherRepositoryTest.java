package fi.example.lowcode.repository;

import fi.example.lowcode.entity.Publisher;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.history.Revisions;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static fi.example.lowcode.HateoasTestUtil.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void createPublisher() throws Exception {
        expectPostCreated(mvc, ENTITIES, NEW_BODY)
                .andExpect(jsonPath("$.name", is("name")));
        Publisher publisher = publisherRepository.findAll().iterator().next();
        assertNotNull(publisher);
        assertEquals(1, publisher.id);
    }

    @Test
    @Sql("data/createPublisher100.sql")
    void testFindAll() throws Exception {
        expectGetOKSize(mvc, ENTITIES, 1);
    }

}