import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/User';
import { Router } from '@angular/router';
import { UsuarioApiService } from '../../../app/services/usuario-api.service';
import { AuthGuardService } from '../../shared/guards/auth-guard.service';
import { element } from '@angular/core/src/render3';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  userF = new User();
  valida = false;
  users: User[] = [];
  authBtn: HTMLElement;
  constructor(private api: UsuarioApiService, private router: Router) { }
  login() : void {
    this.users.forEach((user) => {
      if(this.userF.email === user.email && this.userF.senha === user.senha){
        this.valida = true;
        localStorage.setItem('usuarioLogado', user.email);
      }
    });
    if(this.valida){
      this.router.navigate(["/caronas-list"]);
    }else{
      alert('Ensira os dados corretamente!');
    }
    this.valida = false;
  }

  getListaUsuarios() {
    this.api.getUsuarios().subscribe(users => {
      this.users = users;
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
    this.getListaUsuarios();
  }

}
