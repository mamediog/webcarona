import { Component, OnInit } from '@angular/core';
import { Carona } from 'src/app/shared/Carona';
import { CaronaApiService } from 'src/app/services/carona-api.service';
import { Router } from '@angular/router';
import { FormGroup, NgForm, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-carona',
  templateUrl: './carona.component.html',
  styleUrls: ['./carona.component.sass']
})
export class CaronaComponent implements OnInit {
  searchForm: FormGroup;
  
  erroMsg: string;
  titulo = 'Lista de Caronas';
  caronasList: Carona[] = [];

  constructor(private api: CaronaApiService,
    private router: Router, private formBuilder: FormBuilder) { }

  onFormSubmit(form: NgForm){
    var nome = this.searchForm.value;
    this.caronasList = [];
    this.api.getCaronaPorCidade(nome.cidade).forEach((values) => {
      this.caronasList = values;
    });
  }

  getCaronas() {
    this.api.getCaronas().subscribe(caronas => {
      this.caronasList = caronas;
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
    this.getCaronas();
    this.searchForm = this.formBuilder.group({
      'cidade': [null, null]
    });
  }

}
