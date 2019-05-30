package com.damian.todo_Final.entities;


import javax.persistence.*;
import java.util.Objects;


@Table(name="todos")
@Entity
public class Todos {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_description")
    private String taskDescritpion;

    @Column(name = "task_Status")
    private boolean taskStatus;


    @Column(name = "task_date")
    private String taskDate;


    public Todos(String taskDescritpion, boolean taskStatus, String taskDate) {
        this.taskDescritpion = taskDescritpion;
        this.taskStatus = taskStatus;
        this.taskDate = taskDate;
    }

    public Todos() {

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

    public boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public boolean isTaskStatus() {
        return taskStatus;
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
                ", taskStatus='" + taskStatus + '\'' +
                ", taskDate='" + taskDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todos todos = (Todos) o;
        return getId() == todos.getId() &&
                isTaskStatus() == todos.isTaskStatus() &&
                Objects.equals(getTaskDescritpion(), todos.getTaskDescritpion()) &&
                Objects.equals(getTaskDate(), todos.getTaskDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTaskDescritpion(), isTaskStatus(), getTaskDate());
    }
}
