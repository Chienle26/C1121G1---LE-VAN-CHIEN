import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {TodoList} from "../model/todo-list";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  todoApi = 'http://localhost:3000/todo';

constructor(private http: HttpClient) { }

getAll(): Observable<TodoList[]> {
  return this.http.get<TodoList[]>(`${this.todoApi}`);
}

getById(id: number): Observable<TodoList> {
  return this.http.get<TodoList>(`${this.todoApi}/${id}`);
}

save(todo: TodoList): Observable<TodoList> {
  return this.http.post<TodoList>(`${this.todoApi}`, todo);
}

update(id: number, todo: TodoList): Observable<TodoList> {
  return this.http.put<TodoList>(`${this.todoApi}/${id}`, todo);
}
}
