import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import { ProductDataService } from 'src/app/services/data/product-data.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  // dependency over product data service
  constructor(public productService: ProductDataService) { }

  ngOnInit() {
  }


  saveProduct(txtName:HTMLInputElement, txtCategory:HTMLInputElement, txtCost:HTMLInputElement):void{
    
    let product = new Product(txtName.value, txtCategory.value, parseInt(txtCost.value));

    // need to send it to server using product Data Service
    this.productService.addNewProduct(product).subscribe((response) => console.log(response));


    // reset the form
    txtName.value = "";
    txtCategory.value = "";
    txtCost.value = "";
}

}
