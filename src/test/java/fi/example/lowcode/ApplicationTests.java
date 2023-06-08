package fi.example.lowcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static fi.example.lowcode.HateoasTestUtil.MEM_DB_PROPERTY;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = { MEM_DB_PROPERTY })
class ApplicationContextTests {

	@Autowired
	private ApplicationContext context;
	@Test
	void contextLoads() {
		assertNotNull(context);
	}

}
