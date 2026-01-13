import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model'; // Importa el modelo que creaste

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // URL de tu API en Spring Boot
  private API_URL = 'http://localhost:8080/user';

  constructor(private http: HttpClient) { }

  // Método para el Login
  login(email: string, password: string): Observable<string> {
    const params = { email, password };
    return this.http.post(`${this.API_URL}/login`, null, { 
      params, 
      responseType: 'text' 
    });
  }

  // Opcional: Método para listar usuarios y verificar que "abel" existe
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.API_URL}/getAll`);
  }
}