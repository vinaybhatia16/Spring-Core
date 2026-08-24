import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html'
})
export class RoleComponent {

  endpoint = 'http://localhost:8080/Role/save'

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror: {}
  }

  constructor(private httpService: HttpServiceService) { }

  save() {
    this.form.successMessage = '';
    this.form.errorMessage = '';
    this.form.inputerror = {};
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
        return;
      }
      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
        return;
      }
      if (response.success == true) {
        this.form.successMessage = response.result.message;
      }
    });

  }


}