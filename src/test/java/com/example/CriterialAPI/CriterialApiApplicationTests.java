package com.example.CriterialAPI;

import com.example.CriterialAPI.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CriterialApiApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void repoTest(){
		//TODO: It gives us the implementation class of BookRepository interface at runtime.

		String className = bookRepository.getClass().getName();
		String packageName = bookRepository.getClass().getPackageName();

		System.out.println("class Name is"+className);
		System.out.println("Package Name is"+packageName);
	}

}
