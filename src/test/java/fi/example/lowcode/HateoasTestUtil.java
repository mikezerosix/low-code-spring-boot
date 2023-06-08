package fi.example.lowcode;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HateoasTestUtil {
    public static final String MEM_DB_PROPERTY = "spring.datasource.url=jdbc:h2:mem:mem-h2db";
    public static ResultActions getAction(MockMvc mvc, String entities) throws Exception {
        return mvc.perform(get("/api/" + entities).with(csrf())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE));
    }

    public static ResultActions expectGetOK(MockMvc mvc, String entities) throws Exception {
        return getAction(mvc,entities).andExpect(status().isOk());
    }

    public static ResultActions expectGetOKSize(MockMvc mvc, String entities, int size) throws Exception {
        return expectGetOK(mvc, entities)
                .andExpect(jsonPath("$._embedded." + entities + ".length()", is(size)));
    }

    public static ResultActions postAction(MockMvc mvc, String entities, String body) throws Exception {
        return mvc.perform(post("/api/" + entities).with(csrf())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(body));
    }

    public static ResultActions expectPostCreated(MockMvc mvc, String entities, String body) throws Exception {
        return postAction(mvc, entities, body).andExpect(status().isCreated());
    }
}
