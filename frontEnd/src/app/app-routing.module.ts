import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { UserComponent } from './user/user.component';
//estemodulo se encuarga de las rutas
//constante de rutas
const routes: Routes = [
    { path: '',component: HomeComponent  },
    { path: 'userComponent', component: UserComponent }
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule { }
