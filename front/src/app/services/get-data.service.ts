import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Todo} from '../todo-list/todo-list.component';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class GetDataService {
private todo: Todo;
  constructor(private http: HttpClient) { }


  getAllTodosFromDatabase() {
    return this.http.get<Todo[]>('http://wwww.localhost:8081/todos');
  }


  getSingleTodo(id) {
    return this.http.get<Todo>(`http://www.localhost:8081${id}`);
  }



  deleteSingleTodo(id) {
    return this.http.delete(`http://www.localhost:8081/todos/${id}`);
}





  createNewTodoTask(todo) {
    return this.http.post<Todo>('http://www.localhost:8081/todos', todo);
  }


  updateSingleTodo(id, todo) {
    return this.http.put<Todo>(`http://localhost:8081/todos/${id}`, todo);
  }




}
