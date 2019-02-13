import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { UsuarioApiService } from './services/usuario-api.service';
import { AuthGuardService } from './shared/guards/auth-guard.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'Carona';
  validaToken: string;
  constructor(private router: Router, private api: UsuarioApiService) {}

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

  isLogged() {
    const token = localStorage.getItem("usuarioLogado");
    if(token == null){
      return false;
    }
  }

  logout() {
    localStorage.setItem("usuarioLogado", "");
    this.router.navigate(['/login']);
  }
}
