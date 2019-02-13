import { Component, OnInit, Input } from '@angular/core';
import { Carona } from 'src/app/shared/Carona';
import { FormGroup, FormBuilder, NgForm, Validators } from '@angular/forms';
import { CaronaApiService } from 'src/app/services/carona-api.service';
import { Router } from '@angular/router';
import { UsuarioApiService } from 'src/app/services/usuario-api.service';
import { User } from 'src/app/shared/User';

@Component({
  selector: 'app-carona-add',
  templateUrl: './carona-add.component.html',
  styleUrls: ['./carona-add.component.sass']
})
export class CaronaAddComponent implements OnInit {

  //Melhoria trazendo o Objeto
  @Input() caronas = new Carona();
  caronasForm: FormGroup;
  isLoadingResults = false;
  usuario = new User;
  constructor(private api: CaronaApiService,
    private router: Router,
    private formBuilder: FormBuilder, private apiUser: UsuarioApiService) { }

  onFormSubmit(form: NgForm) {
    const { cidadeOrigem, cidadeDestino, vagas,
      preco, data, hora, descricao } = this.caronasForm.value;
    this.caronas = new Carona();
    this.caronas.cidadeOrigem = cidadeOrigem;
    this.caronas.cidadeDestino = cidadeDestino;
    this.caronas.vagas = vagas;
    this.caronas.preco = preco;
    this.caronas.data = data;
    this.caronas.hora = hora;
    this.caronas.status = 1;
    this.caronas.usuario = this.getUser();
    this.caronas.descricao = descricao;

    this.api.addCarona(this.caronas)
      .subscribe(res => {
        console.log(res);
        this.router.navigate(['/']);
      }, (err) => {
        console.log(err);
      });
  }

  getUser(): User {
    const token = localStorage.getItem('usuarioLogado');
    this.apiUser.getUsuarios().forEach((user) => {
      user.forEach((value) => {
        if (token.toString() === value.email.toString()) {
          this.usuario = value;
        }
      });
    });
    return this.usuario;
  }

  ngOnInit() {
    this.getUser();
    this.caronasForm = this.formBuilder.group({
      'cidadeOrigem': [null, Validators.required],
      'cidadeDestino': [null, Validators.required],
      'vagas': [null, Validators.required],
      'preco': [null, Validators.required],
      'data': [null, Validators.required],
      'hora': [null, Validators.required],
      'descricao': [null, null]
    });
  }

}
