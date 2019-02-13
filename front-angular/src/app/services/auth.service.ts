import { Injectable, EventEmitter } from '@angular/core';
import { User } from '../shared/User';
import { Router } from '@angular/router';
import { UsuarioApiService } from './usuario-api.service';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private api: UsuarioApiService, private router: Router) { }
  users: User[] = [];
  private valida: boolean = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();

  doLogin(userList: User[], userF: User) : void {
    userList.forEach((user) => {
      if(userF.email === user.email && userF.senha === user.senha){
        this.valida = true;
        localStorage.setItem('usuarioLogado', user.email);
        this.mostrarMenuEmitter.emit(true);
        this.router.navigate(["/caronas-list"]);
      }else{
        this.valida = false;
        this.mostrarMenuEmitter.emit(true);
      }
    });
  }
}
