import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import {Router, RouterModule} from '@angular/router';
import { ErrorComponent } from './error/error.component';
import {AppRouting} from './app.routing.';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {HttpInterceptorService} from './services/http-interceptor/http-interceptor.service';
import { AddSingleTodoFormComponent } from './add-single-todo-form/add-single-todo-form.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    ErrorComponent,
    AddSingleTodoFormComponent
  ],
  imports: [
    BrowserModule,
    AppRouting,
    RouterModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
