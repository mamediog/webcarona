import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatInputModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatSortModule,
  MatTableModule,
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule, 
  MatToolbarModule,
  MatMenuModule, MatSidenavModule, MatListModule } from "@angular/material";
import { NavComponent } from './nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { LoginComponent } from './components/login/login.component';
import { UsuarioAddComponent } from './components/usuarios/usuario-add/usuario-add.component';
import { CaronaComponent } from './components/caronas/carona/carona.component';
import { UsuarioComponent } from './components/usuarios/usuario/usuario.component';
import { CaronaAddComponent } from './components/caronas/carona-add/carona-add.component';
import { CaronaEditComponent } from './components/caronas/carona-edit/carona-edit.component';
import { CaronaListIdComponent } from './components/caronas/carona-list-id/carona-list-id.component';
import { UsuarioEditComponent } from './components/usuarios/usuario-edit/usuario-edit.component';
import { AuthService } from './services/auth.service';
@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    UsuarioAddComponent,
    CaronaComponent,
    UsuarioComponent,
    CaronaAddComponent,
    CaronaEditComponent,
    CaronaListIdComponent,
    UsuarioEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatMenuModule,
    LayoutModule,
    MatSidenavModule,
    MatListModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
