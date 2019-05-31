import { Component, OnInit } from '@angular/core';
import {GetDataService} from '../services/get-data.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todos: Todo[];
  message: string;

  constructor(private getDataService: GetDataService, private router: Router) { }

  ngOnInit() {
    this.getAllTodosToDisplay();
  }

  getAllTodosToDisplay() {
    this.getDataService.getAllTodosFromDatabase().subscribe(
      response => {
        this.todos = response;
      }
    );
  }
addSingleTodo() {
    console.log('click click');
    this.router.navigate(['todo']);
}


  updateSingleTodo() {
      this.router.navigate(['todo']);
  }


  deleteSingleTodo(id) {
    this.getDataService.deleteSingleTodo(id).subscribe(
      response => {
        this.getAllTodosToDisplay();

      }
    );
  }


}

export class Todo {
  constructor(
    public id: number,
    public taskDescritpion: string,
    public taskStatus: boolean,
    public taskDate: Date
  ) {

  }
}
