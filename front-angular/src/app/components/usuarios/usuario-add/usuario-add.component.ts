import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioApiService } from '../../../services/usuario-api.service';
import { User } from '../../../shared/User';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Telefone } from 'src/app/shared/Telefone';

@Component({
  selector: 'app-usuario-add',
  templateUrl: './usuario-add.component.html',
  styleUrls: ['./usuario-add.component.sass']
})
export class UsuarioAddComponent implements OnInit {

  //Melhoria trazendo o Objeto
  @Input() users = new User();
  usersForm: FormGroup;
  tels: Telefone;
  isLoadingResults = false;

  constructor(private api: UsuarioApiService,
    private router: Router,
    private formBuilder: FormBuilder) { }

  onFormSubmit(form: NgForm) {
    this.isLoadingResults = true;

    const { nome, email, senha, cpf, ddd1, numero1, ddd2, numero2 } = this.usersForm.value;
    this.users = new User();
    this.users.nome = nome;
    this.users.email = email;
    this.users.senha = senha;
    this.users.cpf = cpf;

    this.users.telefones = {
      id: null,
      ddd: ddd1,
      numero: numero1,
      ddd2: ddd2 == null ? ddd1 : ddd2,
      numero2: numero2 == null ? numero1 : numero2
    }

    this.api.addUser(this.users)
      .subscribe(res => {
        console.log(res);
        this.router.navigate(['/login']);
      }, (err) => {
        console.log(err);
      });
  }
  ngOnInit() {
    this.usersForm = this.formBuilder.group({
      'nome': [null, Validators.required],
      'email': [null, Validators.required],
      'senha': [null, Validators.required],
      'cpf': [null, Validators.required],
      'ddd1': [null, Validators.required],
      'numero1': [null, Validators.required],
      'ddd2': [null, null],
      'numero2': [null, null]
    });
  }

}
