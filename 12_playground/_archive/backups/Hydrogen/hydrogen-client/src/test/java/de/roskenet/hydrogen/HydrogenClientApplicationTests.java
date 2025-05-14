package de.roskenet.hydrogen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"hydrogen.url=http://localhost:8080/api/"})
public class HydrogenClientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
