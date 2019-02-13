import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/shared/User';
import { Carona } from 'src/app/shared/Carona';
import { FormGroup, FormBuilder, NgForm, Validators } from '@angular/forms';
import { CaronaApiService } from 'src/app/services/carona-api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UsuarioApiService } from 'src/app/services/usuario-api.service';

@Component({
  selector: 'app-carona-edit',
  templateUrl: './carona-edit.component.html',
  styleUrls: ['./carona-edit.component.sass']
})
export class CaronaEditComponent implements OnInit {

  //Melhoria trazendo o Objeto
  @Input() caronas = new Carona();
  caronasForm: FormGroup;
  isLoadingResults = false;
  carona = new Carona();
  idC: number;

  constructor(private api: CaronaApiService,
    private router: Router,
    private formBuilder: FormBuilder, private apiUser: UsuarioApiService, private route: ActivatedRoute) { }

  onFormSubmit(form: NgForm) {
    var { cidadeOrigem, cidadeDestino, vagas,
      preco, data, hora, descricao } = this.caronasForm.value;
    
    this.caronas = new Carona();
    this.caronas.cidadeOrigem = cidadeOrigem;
    this.caronas.cidadeDestino = cidadeDestino;
    this.caronas.vagas = vagas;
    this.caronas.preco = preco;
    this.caronas.data = data;
    this.caronas.hora = hora;
    this.caronas.status = this.carona.status;
    this.caronas.usuario = this.carona.usuario;
    this.caronas.descricao = descricao;
    console.log(this.caronas);
    this.api.updateCarona(this.carona.id, this.caronas)
      .subscribe(res => {
        this.router.navigate(['/caronas-list']);
      }, (err) => {
        console.log(err);
      });
  }

  getCarona() {
    this.api.getCaronaPorId(this.route.snapshot.params['id']).subscribe((carona: Carona) => {
      this.caronasForm.setValue({
        cidadeOrigem: carona.cidadeOrigem,
        cidadeDestino: carona.cidadeDestino,
        vagas: carona.vagas,
        preco: carona.preco,
        data: carona.data,
        hora: carona.hora,
        descricao: carona.descricao
      });
      this.carona = carona;
    });
  }

  ngOnInit() {
    this.getCarona();
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
