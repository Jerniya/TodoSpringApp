package com.example.demo.service;

import com.example.demo.models.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
     private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long Id){
        return todoRepository.findById(Id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public void deleteTodo(Long id){
        todoRepository.delete(getTodoById(id));
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Page<Todo> getAllByPage(int page, int size){
        Pageable pageable=PageRequest.of(page,size);
        return todoRepository.findAll(pageable);
    }
}
