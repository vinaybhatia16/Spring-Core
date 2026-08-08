import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent {

  constructor(private router: Router, private httpService: HttpServiceService) { }

  endpoint = 'http://localhost:8080/Auth/signUp';

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror:{},
  }

  signUp() {

    let _self = this;
    console.log(this.form.data);

    this.httpService.post(this.endpoint, this.form.data, function (response: any) {
      console.log("response: ", response);

if (response.success == false && response.result.inputerror){
_self.form.inputerror= response.result.inputerror;
}

if (response.success == false && response.result.message) {
  _self.form.errorMessage = response.result.message;
}

if (response.success == true) {
  _self.form.successMessage = response.result.message;
}
    })

  }

}
