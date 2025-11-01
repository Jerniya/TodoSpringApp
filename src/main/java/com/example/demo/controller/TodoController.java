package com.example.demo.controller;

import com.example.demo.service.TodoService;
import com.example.demo.models.Todo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("api/v1/todo")
@Slf4j
public class TodoController {
    private static final Logger log = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    ResponseEntity<Todo> getTodo(@RequestParam Long id){
        try{
            Todo getTodo=todoService.getTodoById(id);
            return  new ResponseEntity<>(getTodo,HttpStatus.FOUND);
        }

        catch (RuntimeException exception){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
//    @ApiResponses(value={
//            @ApiResponse(responseCode = "200",description = "Todo created successfully"),
//            @ApiResponse(responseCode = "500",description = "Ouch something went wrong while creating Todo")
//    })
    @PostMapping("/create")
    ResponseEntity<Todo> create(@RequestBody Todo todo){

            Todo todoCreated=todoService.createTodo(todo);
            return new ResponseEntity<>(todoCreated, HttpStatus.OK);

    }

    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
//       log.info("just an info statement");
        return new ResponseEntity<List<Todo>>(todoService.getTodos(),HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Todo> update(@RequestBody Todo todo){
       return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam("id") Long id){
      try{
          todoService.deleteTodo(id);
          return new ResponseEntity<>( "Todo deleted successfully",HttpStatus.OK);
      }
      catch(RuntimeException exception){
          log.info("error occurred!");
          return new ResponseEntity<>("delete operation failed with runtime exception, check the ID passed", HttpStatus.OK);
      }
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getPages(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllByPage(page,size),HttpStatus.OK);
    }

}
