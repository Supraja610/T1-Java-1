import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConvertService {

  constructor() { }

  // method to convert string into upper case
  convertToUpper(str : string) : string{
    return str.toUpperCase();
  }
}
