package com.damian.todo_Final.Controller;



import com.damian.todo_Final.entities.Todos;
import com.damian.todo_Final.services.ITodosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

        return iTodosRepository.findById(id);

    }

    // DELETE SINGLE ITEM

    @DeleteMapping("/todos/{id}")
    public Todos deleteSingleTodo(@PathVariable int id) {



     return iTodosRepository.deleteById(id);
    }

    // SAVE ITEM

    @PostMapping("/todos")
    public Todos saveNewTodo(@Valid @RequestBody Todos todo) {

      /*  Todos newTodo = new Todos();
        newTodo.setId(todo.getId());
        newTodo.setTaskWeight(todo.getTaskWeight());
        newTodo.setTaskDescritpion(todo.getTaskDescritpion());
        newTodo.setTaskDate(todo.getTaskDate());*/

        return iTodosRepository.save(todo);

    }

    // UPDATE ITEM
    @PutMapping("/todos/{id}")
    public Todos updateTodo(@PathVariable int id, @RequestBody Todos todo) throws ResourceNotFoundException {

        todo.setId(todo.getId());
        todo.setTaskDescritpion(todo.getTaskDescritpion());
        todo.setTaskWeight(todo.getTaskWeight());
        todo.setTaskDate(todo.getTaskDate());
        final Todos updatedTodo = iTodosRepository.save(todo);
        return updatedTodo;


         /*   Todos singleTodo = findSingleTodo(todo.getId());
            if(singleTodo != null) {
                BeanUtils.copyProperties(todo, singleTodo);
                iTodosRepository.save(singleTodo);
            }
            return todo;*/



    }


}









