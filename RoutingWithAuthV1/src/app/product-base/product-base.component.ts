import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-product-base',
  templateUrl: './product-base.component.html',
  styleUrls: ['./product-base.component.css']
})
export class ProductBaseComponent implements OnInit {

  // collection of Product type : Array of product type
  // products : Product[];
  products : Array<Product>;

  constructor() { 
    // initialize with dummy data...
    this.products = [
      new Product("First","Books",100),
      new Product("Second","Electronics",500),
      new Product("Third","Games",300)
    ];
    
  }

  // parameter here is $event ~ Product
  addNewProduct(product:Product):void{
    // add new product received from other component 
    this.products.push(product);
  }


  ngOnInit() {
  }

}
