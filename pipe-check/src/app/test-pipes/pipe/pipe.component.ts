import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css']
})
export class PipeComponent implements OnInit {

  name : string;
  rate : number;
  gpa : number;
  hobbies : Array<string>;
  profile : any;
  dob : Date;

  capacity : number;


  constructor() {
    this.name = "First";
    this.rate = 100;
    this.gpa = 1234.56789;
    this.hobbies = ["Football", "Basketball", "Chess", "Reading"];
    this.profile = {
      "email" : "first@mail.com",
      "address" : {
            "lane" : 6,
            "location" : "OMR",
            "city" : "Chennai"
      }
    };
    this.dob = new Date(); // current date
    this.capacity = 5354326345;

   }


  ngOnInit() {
  }

}
