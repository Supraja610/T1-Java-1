import { Component, OnInit } from '@angular/core';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-component-one',
  templateUrl: './component-one.component.html',
  styleUrls: ['./component-one.component.css']
})
export class ComponentOneComponent implements OnInit {

  // need to tell Angular about our dependency over MessageService
  //  need to tell Angular i have requirement of message service in constructor
  constructor(public service : MessageService) { 

  }

  ngOnInit() {
  }

}
