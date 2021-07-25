package com.myorg.cicdspringboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CicdSpringBootApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void verifyHelloMessage() throws Exception {

		String patternString = "(Hello from AWS Continuous Delivery!!! using host: ).*\\/\\d+.\\d+.\\d+.\\d+";
		Matcher<String> regexMatcher = Matchers.matchesRegex(patternString);

		this.mockMvc.perform(get("/home")).andExpect(status().isOk()).andExpect(content().string(regexMatcher));
	}

}
