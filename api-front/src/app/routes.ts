import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';
import { SignInComponent } from './user/sign-in/sign-in.component';
import { DateComponent } from './user/date/date.component';
import { AppComponent } from './app.component';

export const appRoutes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'sign-up', component: SignUpComponent },
    { path: 'login', component: SignInComponent },
    { path: 'date', component: DateComponent }
    ];
