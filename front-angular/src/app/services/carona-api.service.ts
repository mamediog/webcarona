import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Carona } from '../shared/Carona';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type':'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CaronaApiService {

  private BASE_URL: string = "http://localhost:8088/carona";
  private apiUrl = `${this.BASE_URL}/modelo-carona`;

  constructor(private http: HttpClient) { }

  getCaronas(): Observable<Carona[]> {
    return this.http.get<Carona[]>(this.apiUrl).pipe(
      catchError(this.handleError('getCaronas', [])),
    );
  }

  addCarona(carona: Carona): Observable<Carona> {
    return this.http.post<Carona>(this.apiUrl, carona, httpOptions).pipe(
      tap((carona: Carona) => console.log('adicionou o carona' + carona)),
      catchError(this.handleError<Carona>('addCaronas'))
    );
  }

  updateCarona(id: number, carona: Carona): Observable<any> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.put(url, carona, httpOptions).pipe(
      catchError(this.handleError<any>('updateCarona'))
    );
  }

  getCaronaPorId(id: number): Observable<Carona> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Carona>(url).pipe(
      tap(carona => console.log(`busca carona pelo id=${id}`)),
      catchError(this.handleError<Carona>(`busca carona por id=${id}`))
    );
  }
  
  getCaronaPorCidade(cidade: string): Observable<Carona[]> {
    const url = `${this.apiUrl}/filtro?nome=${cidade}`;
    return this.http.get<Carona[]>(url).pipe(
      tap(caronas => console.log(`busca carona ${caronas}`)),
      catchError(this.handleError<Carona[]>(`busca carona pela cidade=${cidade}`))
    );
  }

  deleteCarona(id: number): Observable<Carona> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<Carona>(url, httpOptions).pipe(
      catchError(this.handleError<Carona>('deleteCarona'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(error);
      return of(result as T);
    }
  }
}
