package com.example.demo;

import com.example.demo.daos.ExampleDAO;
import com.example.demo.entities.Example;

import org.junit.jupiter.api.Test;
import org.postgresql.geometric.PGpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class DemoApplicationTests {

	@Autowired
	private ExampleDAO exampleDAO;

	@Test
	void simpleCrudTest() {

		Example e = new Example();
		e.setInfo("info example");
		e.setSinglePoint(new PGpoint(10,15));
		exampleDAO.save(e);
	}

}
