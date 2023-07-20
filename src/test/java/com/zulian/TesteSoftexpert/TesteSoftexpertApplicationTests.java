package com.zulian.TesteSoftexpert;

import com.zulian.TesteSoftexpert.service.CalcularService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TesteSoftexpertApplicationTests {

	@Autowired
	private CalcularService calcularService;

	@Test
	void contextLoads() {
	}

}
