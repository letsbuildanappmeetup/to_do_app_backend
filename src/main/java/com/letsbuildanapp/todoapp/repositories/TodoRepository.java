package com.letsbuildanapp.todoapp.repositories;

import com.letsbuildanapp.todoapp.model.Todo;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends CrudRepository<Todo, UUID> {

    @Query("Select * from todo where title=?0")
    Todo findByTitle(String title);

    @Query("UPDATE todo SET description =?1 WHERE id =?0")
    void updateTodoDesc(UUID uuid, String description);

    @Query("UPDATE todo SET title =?1 WHERE id =?0")
    void updateTodoTitle(UUID uuid, String title);
}
