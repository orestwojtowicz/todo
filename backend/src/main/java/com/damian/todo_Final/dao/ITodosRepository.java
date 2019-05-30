package com.damian.todo_Final.dao;

import com.damian.todo_Final.entities.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITodosRepository extends JpaRepository<Todos, Integer>{



}
