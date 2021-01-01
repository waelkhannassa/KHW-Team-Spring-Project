import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ListBooksService {
  urlBooks = environment.urlBooks;
  book: any;
 username = sessionStorage.getItem('username');
password = sessionStorage.getItem('password');
  constructor( private Http: HttpClient) { }

    listBooks() { 

     /* const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });
        return this.Http.get(this.urlBooks + '/list', { headers }); */
        return this.Http.get(this.urlBooks + '/list');
        }
    
 addBook (myform) {

  //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });
   this.book = {
    'title': myform.value.title,
    'author': myform.value.author,
    'price': myform.value.price,
    'date': myform.value.date
    }
   // return this.Http.post(this.urlBooks + '/add', this.book, {headers});
    return this.Http.post(this.urlBooks + '/add', this.book);
    }
   
    deleteBook(myObj) {
      //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });
     // return this.Http.delete(this.urlBooks + '/' + myObj['idBook'],  {headers})
      return this.Http.delete(this.urlBooks + '/' + myObj['id'])
      }
     

      getBook(id) {
       // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });
      //  return this.Http.get(this.urlBooks + '/' + id,  {headers})
        return this.Http.get(this.urlBooks + '/' + id)
        }

updateBook(myObj) {
 //  const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });
 // return this.Http.put(this.urlBooks + '/' + myObj['idBook'], myObj,  {headers});
 return this.Http.put(this.urlBooks + '/' + myObj['id'], myObj);
 }

  }