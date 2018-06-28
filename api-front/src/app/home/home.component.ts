import { Hello } from './modelHome.ts/home';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HelloService  } from '../home/service/helloService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private hello: Hello;

  constructor(private router: Router , private helloService: HelloService) { }


  ngOnInit() {
  }

   Logout() {
    localStorage.removeItem('app_token');
    this.router.navigate(['/login']);
   }

}
