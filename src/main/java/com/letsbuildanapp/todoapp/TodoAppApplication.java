package com.letsbuildanapp.todoapp;

import com.letsbuildanapp.todoapp.model.Todo;
import com.letsbuildanapp.todoapp.repositories.TodoRepository;
import com.letsbuildanapp.todoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.datastax.driver.core.utils.UUIDs;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {

		this.todoRepository.deleteAll();

		// save a couple of users
//		this.userRepository.save(new User(UUIDs.timeBased(), "Alice", "Smith"));
//		this.userRepository.save(new User(UUIDs.timeBased(), "Bob", "Smith"));

		this.todoRepository.save(new Todo(UUIDs.timeBased(), "Morning todo", "Go for a run"));
		this.todoRepository.save(new Todo(UUIDs.timeBased(), "Evening todo", "Dinner with friends"));



		// fetch all todo's
		System.out.println("users found with findAll():");
		System.out.println("-------------------------------");
		for (Todo todo : this.todoRepository.findAll()) {
			System.out.println(todo);
		}
		System.out.println();

//		// fetch an individual user
//		System.out.println("user found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(this.userRepository.findByFirstName("Alice"));
//
//		System.out.println("users found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (User user : this.userRepository.findByLastName("Smith")) {
//			System.out.println(user);
//		}
	}


	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
}
