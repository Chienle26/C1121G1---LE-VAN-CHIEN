import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  display = '';
  constructor() { }
  ngOnInit(): void {
  }
  // tslint:disable-next-line:variable-name
  nhapLieu(number: string) {
    this.display += number;
  }

  tinh() {
    // tslint:disable-next-line:no-eval
    this.display = eval(this.display);
  }

  xoa() {
    this.display = '';
  }
}
