package com.damian.todo_Final.entities;


import javax.persistence.*;
import java.util.Objects;


@Table(name="todos")
@Entity
public class Todos {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_description")
    private String taskDescritpion;

    @Column(name = "task_weight")
    private String taskWeight;

    @Column(name = "task_date")
    private String taskDate;


    public Todos(String taskDescritpion,  String taskDate, String taskWeight, int id) {
        this.taskDescritpion = taskDescritpion;
        this.id = id;
        this.taskDate = taskDate;
        this.taskWeight = taskWeight;
    }

    public Todos() {

    }

    public String getTaskWeight() {
        return taskWeight;
    }

    public void setTaskWeight(String taskWeight) {
        this.taskWeight = taskWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskDescritpion() {
        return taskDescritpion;
    }

    public void setTaskDescritpion(String taskDescritpion) {
        this.taskDescritpion = taskDescritpion;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "id=" + id +
                ", taskDescritpion='" + taskDescritpion + '\'' +
                ", taskStatus='" + '\'' +
                ", taskDate='" + taskDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todos todos = (Todos) o;
        return getId() == todos.getId() &&
                Objects.equals(getTaskDescritpion(), todos.getTaskDescritpion()) &&
                Objects.equals(getTaskDate(), todos.getTaskDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTaskDescritpion(), getTaskDate());
    }
}
