import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: any;
  onSubmit(f: NgForm){
    switch (f.value) {
      case 'addition':
        // tslint:disable-next-line:radix
        this.result = parseInt(f.value.number1) + parseInt(f.value.number2);
        break;
      case 'subtraction':
        // tslint:disable-next-line:radix
        this.result = parseInt(f.value.number1) - parseInt(f.value.number2);
        break;
      case 'multiplication':
        // tslint:disable-next-line:radix
        this.result = parseInt(f.value.number1) * parseInt(f.value.number2);
        break;
      case 'division':
        // tslint:disable-next-line:radix
        if (parseInt(f.value.number2) === 0){
          this.result = 'Number 2 can not 0!';
        } else {
          // tslint:disable-next-line:radix
          this.result = parseInt(f.value.number1) / Number.parseInt(f.value.number2);
        }
        break;
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
