import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { ListBooksComponent } from './list-books/list-books.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './services/auth-gaurd.service';
import { UdpateBookComponent } from './udpate-book/udpate-book.component';

const routes: Routes = [
  {path : '' , pathMatch : 'full', redirectTo : "app-root"},
 { path : 'listbook', component : ListBooksComponent, canActivate: [AuthGaurdService]},
 { path : 'addBook', component : AddBookComponent , canActivate: [AuthGaurdService]},
 { path : 'updateBook/:id', component : UdpateBookComponent, canActivate: [AuthGaurdService]},
 { path: 'login', component: LoginComponent },
 { path: 'logout', component: LogoutComponent , canActivate: [AuthGaurdService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes , {useHash : true})],
 
  exports: [RouterModule]
})
export class AppRoutingModule { }
