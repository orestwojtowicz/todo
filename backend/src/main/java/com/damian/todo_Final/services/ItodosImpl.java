package com.damian.todo_Final.services;


import com.damian.todo_Final.dao.ITodosRepository;
import com.damian.todo_Final.entities.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItodosImpl implements ITodosService{


    @Autowired
    private ITodosRepository iTodosRepository;




    @Override
    public List<Todos> findAll() {
        return iTodosRepository.findAll();
    }
    @Override
    public Todos deleteById(int id) {

        Todos todo = findById(id);

        if(todo==null) return null;

        iTodosRepository.delete(todo);

        return todo;

    }






    @Override
    public Todos findById(int theId) {
        Optional<Todos> result = iTodosRepository.findById(theId);
        Todos todos;
        if(result.isPresent()) {
            todos = result.get();
        } else {
            throw new RuntimeException("Could not find this taks ");
        }
        return todos;

    }



    @Override
    public Todos save(Todos todos) {
      return iTodosRepository.save(todos);
    }





}



























