import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/User';
import { Router, ActivatedRoute } from '@angular/router';
import { UsuarioApiService } from 'src/app/services/usuario-api.service';
import { Telefone } from 'src/app/shared/Telefone';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.sass']
})

export class UsuarioComponent implements OnInit {

  titulo = 'Perfil';
  usuario = new User();
  telefones = new Telefone();

  constructor(private api: UsuarioApiService,
    private router: Router, private route: ActivatedRoute) { }

  edit(id: number){
    this.router.navigate(['/user-edit/' + id]);
  }

  getUsuario(){
    const token = localStorage.getItem('usuarioLogado');
    this.api.getUsuarios().forEach((value) => {
      value.forEach((user) => {
        if(token.toString() === user.email.toString()){
          this.usuario = user;
          this.telefones = user.telefones;
        }
      });
    });
  }

  ngOnInit() {
    this.getUsuario();
  }

}
