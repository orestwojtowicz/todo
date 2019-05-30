package com.damian.todo_Final.services;



import com.damian.todo_Final.entities.Todos;

import java.util.List;

public interface ITodosService {

    List<Todos> findAll();

    Todos deleteById(int id);

    Todos findById(int id);




    Todos save(Todos todos);





}
