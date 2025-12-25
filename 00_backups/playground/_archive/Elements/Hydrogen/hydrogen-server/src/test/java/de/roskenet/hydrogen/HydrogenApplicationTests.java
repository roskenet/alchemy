package de.roskenet.hydrogen;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HydrogenApplicationTests {

    @Autowired
    private MockMvc mvc;
    
	@Test
	public void testApiValue() throws Exception {
	    mvc.perform(get("/api/HelloWorld"))
	        .andDo(print())
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.elementValue").value("HelloWorld"));
	}
}

// https://blog.doubleslash.de/spring-boot-webservice-integration-test/