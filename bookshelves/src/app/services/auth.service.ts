import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  createNewUser(email: string, password: string) {
    return new Promise(
      (resolve, reject) => {
        this.httpClient.post('http://localhost:8080/users');
      }
    );
  }
}
