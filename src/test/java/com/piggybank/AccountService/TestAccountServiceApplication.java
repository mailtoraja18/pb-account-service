package com.piggybank.AccountService;

import com.mongodb.MongoClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAccountServiceApplication {

	@Autowired
	MongoClient mongoClient;


	@Test
	public void contextLoads() {
		System.out.println(System.getenv());
		mongoClient.getDatabaseNames().forEach(
				name -> System.out.println("[" + name + "]" + mongoClient.getDB(name).getCollectionNames())
		);
	}

}
