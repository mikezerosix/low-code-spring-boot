package fi.example.lowcode.cucumber;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class LoginSteps implements En {

    public LoginSteps() {
        Before(() -> {

        });
        Given("A user exists with the username {string} and password {string}", (String string, String string2) -> {
            // TODO: impl

        });
        When("The user enters the username {string} and password {string}", (String string, String string2) -> {
            // TODO: impl

        });
        Then("The user is not logged in and sees an error message", () -> {
            // TODO: impl

        });
        Then("The user is logged in", () -> {
            // TODO: impl
        });
    }

}
