import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient) { }

  post(endpoint: any, formData: any, callBack: any) {
    this.httpClient.post(endpoint, formData , {withCredentials : true}).subscribe((response) => {
      callBack(response);
    })
  }

  get(endpoint: any, callback: any) {
    this.httpClient.get(endpoint , {withCredentials : true}).subscribe((response) => {
      callback(response);
    })
  }

}
