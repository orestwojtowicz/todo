import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Todo} from '../todo-list/todo-list.component';


@Injectable({
  providedIn: 'root'
})
export class GetDataService {

  constructor(private http: HttpClient) { }


  getAllTodosFromDatabase() {
    return this.http.get<Todo[]>('http://wwww.localhost:8081/todos');
  }


  createNewTodoTask(todo) {
    return this.http.post<Todo>('http://www.localhost:8081/todos', todo);
  }


  getSingleTodo(id) {
    return this.http.get<Todo>(`http://www.localhost:8081${id}`);
  }



  deleteSingleTodo(id) {
    return this.http.delete(`http://www.localhost:8081/todos/${id}`);
}


  updateSingleTodo(id, todo) {
    return this.http.put<Todo>(`http://localhost:8081/${id}`, todo);
  }



}
