package com.letsbuildanapp.todoapp;

import com.letsbuildanapp.todoapp.model.Todo;
import com.letsbuildanapp.todoapp.repositories.TodoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.datastax.driver.core.utils.UUIDs;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	private final static Logger logger = Logger.getLogger(TodoAppApplication.class);

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {

		this.todoRepository.deleteAll();

		this.todoRepository.save(new Todo(UUIDs.timeBased(), "Morning todo", "Go for a run"));
		this.todoRepository.save(new Todo(UUIDs.timeBased(), "Evening todo", "Dinner with friends"));

		// fetch all todo's
		logger.info("All todo's");
		logger.info("-----------------------------");

		List<Todo> todos = new ArrayList<>();
		Iterable<Todo> toDosRepositoryAll = this.todoRepository.findAll();
		toDosRepositoryAll.forEach(todos::add);
		logger.info("This is info about todos : " + todos);

		logger.info("-----------------------------");
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
}
