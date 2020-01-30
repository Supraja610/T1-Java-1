import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_URL = "http://localhost:3000/products"; // url of server

@Injectable({
  providedIn: 'root'
})
// service to interact with REST Server for Product entity
export class ProductDataService {

  // recieve the Http Service injected
  constructor(public http : HttpClient) { 

  }

  // gets product list from server and returns back
  getAllProducts(){
    // send request to server to get all products
    // this.http.post(API_URL);

    // will send a request to API_URL with http verb GET(retrieval)
    // method will wait for data to receive
    // return data back to component
    return this.http.get(API_URL);
    
    
    // this.http.delete(API_URL);



  }

}
