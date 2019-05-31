import {RouterModule, Routes} from '@angular/router';
import {ErrorComponent} from './error/error.component';
import {TodoListComponent} from './todo-list/todo-list.component';
import {NgModule} from '@angular/core';
import {AddSingleTodoFormComponent} from './add-single-todo-form/add-single-todo-form.component';


const routes: Routes = [
  { path: '', component: TodoListComponent},
  { path: 'todos', component: TodoListComponent},
  { path: 'todo', component: AddSingleTodoFormComponent},
  { path: '**', component: ErrorComponent}
  ];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRouting { }
