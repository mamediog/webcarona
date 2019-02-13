import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/shared/User';
import { FormGroup, FormBuilder, NgForm, Validators } from '@angular/forms';
import { UsuarioApiService } from 'src/app/services/usuario-api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Telefone } from 'src/app/shared/Telefone';

@Component({
  selector: 'app-usuario-edit',
  templateUrl: './usuario-edit.component.html',
  styleUrls: ['./usuario-edit.component.sass']
})
export class UsuarioEditComponent implements OnInit {

  //Melhoria trazendo o Objeto
  @Input() usuario = new User();
  usersForm: FormGroup;
  user = new User();

  constructor(private api: UsuarioApiService,
    private router: Router,
    private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  onFormSubmit(form: NgForm) {
    var { nome, email, ddd, numero, ddd2, numero2 } = this.usersForm.value;
    this.usuario = new User();
    this.usuario.id = this.user.id;
    this.usuario.nome = nome;
    this.usuario.email = email;
    this.usuario.senha = this.user.senha;
    this.usuario.cpf = this.user.cpf;
    this.usuario.telefones = {
      id: this.user.telefones.id,
      ddd: ddd,
      numero: numero,
      ddd2: ddd2 == null ? ddd : ddd2,
      numero2: numero2 == null ? numero : numero2
    }
    console.log(this.usuario);
    this.api.updateUser(this.usuario)
      .subscribe(res => {
        this.router.navigate(['/usuario']);
      }, (err) => {
        console.log(err);
      });
  }

  getUser() {
    this.api.getUsuarioPorId(this.route.snapshot.params['id']).subscribe((user: User) => {
      this.user = user;
      console.log(user.telefones.id);
      this.usersForm.setValue({
        nome: user.nome,
        email: user.email,
        ddd: user.telefones.ddd,
        numero: user.telefones.numero,
        ddd2: user.telefones.ddd2,
        numero2: user.telefones.numero2
      });
    });
  }

  ngOnInit() {
    this.getUser();
    this.usersForm = this.formBuilder.group({
      'nome': [null, Validators.required],
      'email': [null, Validators.required],
      'ddd': [null, Validators.required],
      'numero': [null, Validators.required],
      'ddd2': [null, null],
      'numero2': [null, null]
    });

  }

}
