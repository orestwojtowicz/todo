package com.damian.todo_Final.entities;

public enum TaskWeight {
    IMPORTANT ("Important"),
   NOT_IMPORTANT ("Not_Important");

   private final String name;

           TaskWeight(String name) {
               this.name = name;
           }
}
