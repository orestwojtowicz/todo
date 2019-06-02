import { Component, OnInit } from '@angular/core';
import {GetDataService} from '../services/get-data.service';
import {Router} from '@angular/router';







export class Todo {
  constructor(
    public id: number,
    public taskDescritpion: string,
    public taskWeight: string,
    public taskDate: Date
  ) {

  }
}




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

  editSingleTodo(id) {
    console.log('user to update with io = ' + id);
    this.router.navigate(['todo', id]);
  }
  getAllTodosToDisplay() {
    this.getDataService.getAllTodosFromDatabase().subscribe(
      response => {
        this.todos = response;
        console.log(response);
      }
    );
  }
addSingleTodo() {
    console.log('id add single ');
    this.router.navigate(['todo', -1]);
}





  deleteSingleTodo(id) {
    this.getDataService.deleteSingleTodo(id).subscribe(
      response => {
        this.getAllTodosToDisplay();

      }
    );
  }
}


/*
{id: 67, taskDescritpion: "PIMPEk", taskWeight: "Not-Important", taskDate: "2019-06-01T21:48:45.157Z"}*/


