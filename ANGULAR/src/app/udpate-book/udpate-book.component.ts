import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { book } from '../Entities'
import { ListBooksService } from '../services/books/list-books.service';
@Component({
  selector: 'app-udpate-book',
  templateUrl: './udpate-book.component.html',
  styleUrls: ['./udpate-book.component.css']
})
export class UdpateBookComponent implements OnInit {
  id;
  title;
  author;
  price;
  date;
  booktoUpdate;
  constructor(private activated_route: ActivatedRoute, private serviceC: ListBooksService, private router: Router) { }

  ngOnInit(): void {

    this.activated_route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
        console.log(this.id)
      }
    );
    console.log("*********************");
    this.booktoUpdate = this.serviceC.getBook(this.id).subscribe(
      response => {
        console.log(response);
        this.id = response["id"];
        this.title = response["title"];
        this.author = response["author"];
        this.price = response["price"];
        this.date = response["date"];
      }
    );
    console.log(this.booktoUpdate);

  }
  updateBook() {
    this.booktoUpdate = {
      'title': this.title,
      'author': this.author,
      'price': this.price,
      'date': this.date,
      'id': this.id
    }

    this.serviceC.updateBook(this.booktoUpdate).subscribe(
      response => {
        console.log(response);
      }
    );
    this.router.navigate(['/listbook']);
  }
}