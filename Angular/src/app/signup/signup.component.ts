import { Component } from '@angular/core';
import { Router } from '@angular/router';   

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent {
  constructor(private router: Router ) { }

  form: any = {
    errorMessage: '',
    successMessage: ''
  }

  signUp() {

    console.log(this.form.firstName);
    console.log(this.form.lastName);
    console.log(this.form.login);
    console.log(this.form.password);
    console.log(this.form.dob);
  }

}
