import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CaronaApiService } from 'src/app/services/carona-api.service';
import { Carona } from 'src/app/shared/Carona';
import { UsuarioApiService } from 'src/app/services/usuario-api.service';
import { User } from 'src/app/shared/User';

@Component({
  selector: 'app-carona-list-id',
  templateUrl: './carona-list-id.component.html',
  styleUrls: ['./carona-list-id.component.sass']
})
export class CaronaListIdComponent implements OnInit {


  titulo = 'Lista de Caronas';
  isLoadingResults = true;
  caronasList: Carona[] = [];
  usuarios: User;
  id: number;

  constructor(private api: CaronaApiService, private apiUsr: UsuarioApiService,
    private router: Router) { }

  add() {
    this.router.navigate(['/carona-add']);
  }

  edit(id: number) {
    this.router.navigate(['/carona-edit/' + id]);
  }

  getCaronas() {
    this.api.getCaronas().subscribe(caronas => {
      this.apiUsr.getUsuarios().subscribe(users => {
        users.forEach((value) => {
          if (localStorage.getItem('usuarioLogado') === value.email) {
            caronas.forEach((car) => {
              if (value.id === car.usuario.id) {
                this.caronasList.push(car);
              }
            });
          }
        });
      });
    }, err => {
      console.log(err);
    });
  }

  changeStatus(id: number, carona: Carona){
    carona.status = carona.status === 1 ? carona.status = 0 : carona.status = 1;
    this.api.updateCarona(id, carona).subscribe(res =>{
      console.log(carona.status);
    }, (err) => {
      console.log(err);
    });
  }

  deletaCarona(id: number) {
    var caronaDeleted = new Carona();
    this.caronasList.forEach((value) => {
      if(id === value.id){
        caronaDeleted = value;
      }
    });

    const index = this.caronasList.indexOf(caronaDeleted, 0);
    if (index > -1) {
      this.caronasList.splice(index, 1);
    }
    this.api.deleteCarona(id)
      .subscribe(res => {
        this.router.navigate(['/caronas-list']);
      }, (err) => {
        console.log(err);
      }
      );
  }

  ngOnInit() {
    this.getCaronas();
  }

}
