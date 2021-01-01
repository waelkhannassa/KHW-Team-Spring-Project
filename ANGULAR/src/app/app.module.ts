import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ListBooksComponent } from './list-books/list-books.component';
import { AddBookComponent } from './add-book/add-book.component';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { UdpateBookComponent } from './udpate-book/udpate-book.component';
import {HttpClient, HTTP_INTERCEPTORS} from '@angular/common/http'

import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BasicAuthHttpInterceptorService } from './services/basic-auth-http-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
   
    ListBooksComponent,
    AddBookComponent,
    UdpateBookComponent,
    LoginComponent,
    LogoutComponent,
    NavbarComponent
  ],
  imports: [
   // CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
   
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BasicAuthHttpInterceptorService,
      multi: true
      }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
