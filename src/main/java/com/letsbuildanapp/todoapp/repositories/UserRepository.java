package com.letsbuildanapp.todoapp.repositories;

import com.letsbuildanapp.todoapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("Select * from user where firstname=?0")
    public User findByFirstName(String firstName);

    @Query("Select * from user where lastname=?0")
    public List<User> findByLastName(String lastName);
}
