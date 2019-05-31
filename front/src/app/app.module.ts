import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import {Router, RouterModule} from '@angular/router';
import { ErrorComponent } from './error/error.component';
import {AppRouting} from './app.routing.';

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRouting,
    RouterModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
