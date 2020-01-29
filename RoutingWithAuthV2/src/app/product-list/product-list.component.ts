import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  // initialize this array with data from other Component
  // need to make it capable to get data from other component
  @Input()
  productsList : Array<Product>;

  constructor() { }

  ngOnInit() {
  }

}
