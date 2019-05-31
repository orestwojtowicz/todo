import { Component, OnInit } from '@angular/core';
import {GetDataService} from '../services/get-data.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Todo} from '../todo-list/todo-list.component';

@Component({
  selector: 'app-add-single-todo-form',
  templateUrl: './add-single-todo-form.component.html',
  styleUrls: ['./add-single-todo-form.component.css']
})
export class AddSingleTodoFormComponent implements OnInit {

  todo: Todo;
  id: number;
  constructor(private addSingleTaskService: GetDataService,
              private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;

    this.todo = new Todo(this.id,  '', false, new Date());

  }


  saveTodo() {

      this.addSingleTaskService.createNewTodoTask(this.todo).subscribe(
        data => {
          this.router.navigate(['todos']);
        }
      );


  }

}

