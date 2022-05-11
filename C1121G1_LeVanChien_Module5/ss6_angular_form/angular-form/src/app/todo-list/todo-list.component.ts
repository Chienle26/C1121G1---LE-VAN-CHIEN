import { Component, OnInit } from '@angular/core';
import {TodoList} from "../todo-list";
import {FormControl} from "@angular/forms";

let _id = 1;
@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  todos: TodoList[] = [];
  content = new FormControl();
  constructor() { }

  ngOnInit(): void {
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: TodoList = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }
}
