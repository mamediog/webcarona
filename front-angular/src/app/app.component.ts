import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { UsuarioApiService } from './services/usuario-api.service';
import { AuthGuardService } from './shared/guards/auth-guard.service';
import { LoginComponent } from './components/login/login.component';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent{
  title = 'Carona';
  validaToken: string;
  mostrarMenu: boolean = false;
  constructor(private router: Router, private auth: AuthService) {}

  navigate(menu: string) {
    if (menu === 'cadastrar') {
      this.router.navigate(['/user-add']);
    } else if (menu === 'home') {
      this.router.navigate(['/']);
    } else if (menu === 'logout') {
      this.logout();
    }else if (menu === 'login') {
      this.router.navigate(['/login']);
    }else if (menu === 'carona-add') {
      this.router.navigate(['/carona-add']);
    } else if (menu === 'caronas-list') {
      this.router.navigate(['/caronas-list']);
    } else if (menu === 'usuario') {
      this.router.navigate(['/usuario']);
    }
  }

  logout() {
    localStorage.setItem("usuarioLogado", "");
    this.router.navigate(['/login']);
    location.reload();
  }

  ngOnInit(){
    this.auth.mostrarMenuEmitter.subscribe(
      mostrar => this.mostrarMenu = mostrar
    );
  }
}
