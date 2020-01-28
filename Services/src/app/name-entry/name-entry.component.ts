import { Component, OnInit } from '@angular/core';
import { ConvertService } from '../services/convert.service';

@Component({
  selector: 'app-name-entry',
  templateUrl: './name-entry.component.html',
  styleUrls: ['./name-entry.component.css']
})
export class NameEntryComponent implements OnInit {

  upperName : string;
  constructor(public convertService : ConvertService) { 

  }

  fun(txt : HTMLInputElement){
    // need to call function of service to convert into upper-case
     this.upperName = this.convertService.convertToUpper(txt.value);
  }

  ngOnInit() {
  }

}
