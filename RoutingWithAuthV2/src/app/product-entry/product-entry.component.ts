import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Product } from '../models/product.model';



@Component({
  selector: 'app-product-entry',
  templateUrl: './product-entry.component.html',
  styleUrls: ['./product-entry.component.css']
})
export class ProductEntryComponent implements OnInit {

  // declare an event object that can send data also of type Product
  // need to make it capable to send data
  @Output()
  submit_info : EventEmitter<Product>;

  constructor() { 
    // initialize event object
    this.submit_info = new EventEmitter();
  }

  ngOnInit() {
  }

  saveProduct(txtName:HTMLInputElement, txtCategory:HTMLInputElement, txtCost:HTMLInputElement):void{
    // create a new Product Object from coming values 
    let product = new Product(txtName.value, txtCategory.value, parseInt(txtCost.value));
   
    // send product object to Product-base component
    // by invocking an event
    this.submit_info.emit(product);// ~ $event

    // reset the form
    txtName.value = "";
    txtCategory.value = "";
    txtCost.value = "";
}

}
