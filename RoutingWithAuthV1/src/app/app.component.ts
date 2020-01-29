import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'route-base-app';

  constructor(private router : Router){

  }

  searchCall(srch : HTMLInputElement){
    // navigate to search-result component
    // special class is needed to navigate programmatically : Router (Service)
    // object of Router class is auto injected
    if(srch.value != ""){
      this.router.navigate(['/search/' + srch.value]); //  connect data
    }
  }
}
