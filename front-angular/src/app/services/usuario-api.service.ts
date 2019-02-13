import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { catchError, tap, map } from 'rxjs/operators';
import { User } from '../shared/User';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class UsuarioApiService {

  private BASE_URL: string = "http://localhost:8088/carona";
  private apiUrl = `${this.BASE_URL}/usuario`;

  constructor(private http: HttpClient) { }

  getUsuarios(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl).pipe(
      catchError(this.handleError('getUsuarios', []))
    );
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl, user, httpOptions).pipe(
      catchError(this.handleError<User>('addUsers'))
    );
  }

  updateUser(user: User){
    return this.http.put(this.apiUrl, user, httpOptions).pipe(
      catchError(this.handleError<any>('updateUsuario'))
    );
  }
  getUsuarioPorId(id: number): Observable<User> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<User>(url).pipe(
      tap(usuario => console.log(`busca usuario pelo id=${id}`)),
      catchError(this.handleError<User>(`busca usuario por id=${id}`))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(error);
      return of(result as T);
    }
  }
}
