package com.letsbuildanapp.todoapp.repository;

import com.letsbuildanapp.todoapp.data.Todo;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, String> {

    @Query("Select * from todo where title=?0")
    public Todo findByTitle(String title);
}
