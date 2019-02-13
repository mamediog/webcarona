import { NgModule } from '@angular/core';
import { Routes, RouterModule, CanActivate } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AuthGuardService } from './shared/guards/auth-guard.service';
import { UsuarioAddComponent } from './components/usuarios/usuario-add/usuario-add.component';
import { Carona } from './shared/Carona';
import { CaronaComponent } from './components/caronas/carona/carona.component';
import { CaronaAddComponent } from './components/caronas/carona-add/carona-add.component';
import { CaronaListIdComponent } from './components/caronas/carona-list-id/carona-list-id.component';
import { CaronaEditComponent } from './components/caronas/carona-edit/carona-edit.component';
import { UsuarioComponent } from './components/usuarios/usuario/usuario.component';
import { UsuarioEditComponent } from './components/usuarios/usuario-edit/usuario-edit.component';

const routes: Routes = [
  //Adicionar Usuario
  {
    path: 'user-add',
    component: UsuarioAddComponent,
    data: { title: 'Adicionar Usuário'}
  },
  //Editar Usuario
  {
    path: 'user-edit/:id',
    component: UsuarioEditComponent,
    data: { title: 'Editar Usuário'},
    canActivate: [AuthGuardService]
  },
  //Listar Usuário
  {
    path: 'usuario',
    component: UsuarioComponent,
    data: { title: 'Perfil Usuário'},
    canActivate: [AuthGuardService]
  },
  // Todas as Caronas (Página Inicial)
  {
    path: '',
    component: CaronaComponent,
    data: { title: 'Lista de Caronas'}
  },
  // Adicionar Carona
  {
    path: 'carona-add',
    component: CaronaAddComponent,
    data: { title: 'Oferecer Carona'},
    canActivate: [AuthGuardService]
  },
  //Caronas Por ID
  {
    path: 'caronas-list',
    component: CaronaListIdComponent,
    data: { title: 'Minhas Caronas'},
    canActivate: [AuthGuardService]
  },
  //Editar Carona
  {
    path: 'carona-edit/:id',
    component: CaronaEditComponent,
    data: { title: 'Editar Carona'},
    canActivate: [AuthGuardService]
  },
  //Login
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
