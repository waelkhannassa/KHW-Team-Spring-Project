import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { book } from '../Entities';
import { ListBooksService } from '../services/books/list-books.service';
import { switchMap, tap } from 'rxjs/operators';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.css']
})
export class ListBooksComponent implements OnInit {
  books : any;
refresh = new Subject<void> ();
  constructor(private serviceC : ListBooksService, private router : Router) { }

  ngOnInit(): void {
   
      this.serviceC.listBooks().subscribe(
        response => {
        this.books = response;
       
        }
        );
       
      
    }
    refreshListBooks() {
    return this.refresh;
    
      }
      deleteBook(myObj) {
   
        this.serviceC.deleteBook(myObj).subscribe(response => {
        console.log(response);
        this.refreshListBooks();
        })
        }
        updateBook(myObj) {
  
          this.router.navigate(['updateBook' + '/' + myObj['id']]);
          }
}
