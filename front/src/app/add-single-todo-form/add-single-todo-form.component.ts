import { Component, OnInit } from '@angular/core';
import {GetDataService} from '../services/get-data.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Todo} from '../todo-list/todo-list.component';


export interface Weight {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-add-single-todo-form',
  templateUrl: './add-single-todo-form.component.html',
  styleUrls: ['./add-single-todo-form.component.css']
})





export class AddSingleTodoFormComponent implements OnInit {






  todo: Todo;
  id: number;


  weights: Weight[] = [
    {value: 'Important', viewValue: 'Important'},
    {value: 'Not-Important', viewValue: 'Not Important'}
  ];



  constructor(private addSingleTaskService: GetDataService,
              private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;

    this.todo = new Todo(this.id,  '', '',  new Date());
    this.addSingleTaskService.getSingleTodo(this.id);

  }


  addSingleTodo() {

      this.addSingleTaskService.createNewTodoTask(this.todo).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['todos']);
        }
      );

  }


}
