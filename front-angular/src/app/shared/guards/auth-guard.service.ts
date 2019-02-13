import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';;
import { User } from 'src/app/shared/User';
import { UsuarioApiService } from '../../../app/services/usuario-api.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  users: User[] = [];
  validaToken: string;
  constructor(private api: UsuarioApiService, private router: Router) { }
  canActivate(): boolean {
    const token = localStorage.getItem('usuarioLogado');
    this.api.getUsuarios().forEach((user) => {
      user.forEach((value) => {
        if(token.toString() === value.email.toString()){
          this.validaToken = value.email;
        }
      });
    });
    if(token !== this.validaToken){
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }
}
