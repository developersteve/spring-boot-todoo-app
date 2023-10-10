package com.todoo.springboottodoapplication.repositories;

import com.todoo.springboottodoapplication.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {  
}
