import { Injectable } from '@angular/core';

// will allow Angular to inject object of this class, whenever demanded
@Injectable({
  providedIn: 'root'
})
export class MessageService {

  message : string;
  constructor() { 
    this.message = "Good morning all..";
  }

  getMessage():string{
    return this.message;
  }
}
