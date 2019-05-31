import {RouterModule, Routes} from '@angular/router';
import {ErrorComponent} from './error/error.component';
import {TodoListComponent} from './todo-list/todo-list.component';
import {NgModule} from '@angular/core';


const routes: Routes = [
  { path: '', component: TodoListComponent},
  { path: '**', component: ErrorComponent}
  ];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRouting { }
