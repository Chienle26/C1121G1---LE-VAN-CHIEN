import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  registerForm: FormGroup;

  constructor() {
    this.registerForm = new FormGroup({
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("",[Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl("",[Validators.required, Validators.minLength(6)]),
      country: new FormControl("",Validators.required),
      age: new FormControl("",[Validators.required,Validators.min(18)]),
      gender: new FormControl("",Validators.required),
      phone: new FormControl("",[Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
    })
  }

  ngOnInit(): void {
  }

  submitRegister() {
    console.log(this.registerForm);
  }

  ValidationConfirmPassword() {
      if (this.registerForm.get('password').value != this.registerForm.get('confirmPassword').value){
        this.registerForm.get('confirmPassword').setErrors({notMatch:'ConfirmPassowrd phải giống Password!'});
      }
  }
}
