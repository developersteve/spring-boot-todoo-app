package com.todoo.springboottodoapplication.config;

import com.todoo.springboottodoapplication.models.TodoItem;
import com.todoo.springboottodoapplication.repositories.TodoItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("Make Coffee");
            TodoItem todoItem2 = new TodoItem("Read the latest blogs");
            TodoItem todoItem3 = new TodoItem("Check for updates");            

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2); 
            todoItemRepository.save(todoItem3);
        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }
    
}
