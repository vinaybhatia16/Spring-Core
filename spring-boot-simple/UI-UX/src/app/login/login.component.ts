import { Component } from '@angular/core';
import { Router , ActivatedRoute } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  constructor(private router: Router, private httpService: HttpServiceService , private activatedRoute : ActivatedRoute) {

    this.activatedRoute.queryParams.subscribe(params => {
      if(params['message']) {
        this.form.successMessage =params['message'];
      }
    });
   }
  endpoint = 'http://localhost:8080/Auth/login';

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror:{}
  }

  signIn() {


    let _self = this;


    this.form.errorMessage = '';
    this.form.successMessage = '';

    this.form.inputerror = {};

    console.log(this.form.data.login);
    console.log(this.form.data.password);

    this.httpService.post(this.endpoint, this.form.data, function (response: any) {
      console.log("response: ", response);
      if (response.success == false && response.result.inputerror) {
        _self.form.inputerror = response.result.inputerror;
        return;
      }

      if (response.success == false && response.result.message) {
        _self.form.errorMessage = response.result.message;
        return;
      }

      if (response.success == true) {
        localStorage.setItem('firstName', response.result.data.firstName);
        localStorage.setItem('roleName', response.result.data.roleName);
        localStorage.setItem('id', response.result.data.id);
        _self.router.navigate(['/welcome']);
      }


    })

  }

  signUp() {
    this.router.navigate(['/signup']);
  }

}
