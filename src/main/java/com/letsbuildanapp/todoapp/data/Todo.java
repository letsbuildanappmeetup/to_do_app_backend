package com.letsbuildanapp.todoapp.data;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;
import lombok.Data;

@Table
@Data
public class Todo {

    @PrimaryKey
    private UUID id;

    private String title;

    private String description;

    public Todo(UUID id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
