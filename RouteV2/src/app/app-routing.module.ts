import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { SearchResultComponent } from './search-result/search-result.component';


// array of Route objects
// each route object holds the relation between url and component
const routes: Routes = [
    // Route object
    { path:"", redirectTo : "home", pathMatch: "full"},
    { path:"home", component: HomeComponent},
    { path:"contactus", component: ContactComponent},
    { path:"aboutus", component: AboutComponent},
    // <url>/:<name by which data is accessed>
    { path:"search/:searchText", component: SearchResultComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // registering routes
  exports: [RouterModule]
})
export class AppRoutingModule { }
