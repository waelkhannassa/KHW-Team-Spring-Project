import { Component, OnInit } from '@angular/core';
import { ListBooksService } from '../services/books/list-books.service';
import {book} from '../Entities'
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor( private serviceAdd : ListBooksService, private router : Router) { }

  ngOnInit(): void {
   
  
  }
  createBook(myform) {
    this.serviceAdd.addBook(myform).subscribe(
    response => {
    console.log(response);
    }
    );
    this.router.navigate(['']);
    } 
  }



