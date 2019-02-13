import { Component, OnInit, EventEmitter } from '@angular/core';
import { User } from 'src/app/shared/User';
import { Router } from '@angular/router';
import { UsuarioApiService } from '../../../app/services/usuario-api.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  userF = new User();
  users: User[] = [];
  authBtn: HTMLElement;


  constructor(private api: UsuarioApiService, private router: Router, private auth: AuthService) { }
  
  mostrarMenu = new EventEmitter<boolean>();

  login(){
    this.auth.doLogin(this.users, this.userF);
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
