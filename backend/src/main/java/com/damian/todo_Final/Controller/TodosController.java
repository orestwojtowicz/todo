package com.damian.todo_Final.Controller;


import com.damian.todo_Final.dao.ITodosRepository;
import com.damian.todo_Final.entities.Todos;
import com.damian.todo_Final.services.ITodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class TodosController {


    @Autowired
    private ITodosService iTodosRepository;

    //  GET ALL
    // OK
    @GetMapping("/todos")
    public List<Todos> getAll() {
        return iTodosRepository.findAll();
    }

    // GET SINGLE ITEM
    // OK

    @GetMapping("/todos/{id}")
    public Todos findSingleTodo(@PathVariable int id) {
        Todos todo = iTodosRepository.findById(id);
        return todo;

    }

    // DELETE SINGLE ITEM

    @DeleteMapping("/todos/{id}")
    public Todos deleteSingleTodo(@PathVariable int id) {



     return iTodosRepository.deleteById(id);
    }

    // SAVE ITEM

    @PostMapping("/todos")
    public Todos saveNewTodo(@Valid @RequestBody Todos todo) {



        return iTodosRepository.save(todo);
    }

    // UPDATE ITEM
    @PutMapping("/todos/{id}")
    public Todos updateTodo(@PathVariable int id, @RequestBody Todos todo) throws ResourceNotFoundException {

        todo.setId(todo.getId());
        todo.setTaskDescritpion(todo.getTaskDescritpion());
        todo.setTaskStatus(todo.getTaskStatus());
        todo.setTaskDate(todo.getTaskDate());
        final Todos updatedTodo = iTodosRepository.save(todo);
        return updatedTodo;
    }


}










