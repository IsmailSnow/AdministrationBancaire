import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../user/service/userService';
import { UserAuthentificationRequest } from '../../user/user-model/userLogin';
import { AuthentificationResponse } from '../../user/user-model/jwtAuthentificationToken';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {


  private auth: UserAuthentificationRequest = new UserAuthentificationRequest();
  private value: AuthentificationResponse = new AuthentificationResponse();
  private tokenKey: string = 'app_token';
  private homeResponse:string;
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }
     OnSubmit(userName , password) {
    this.auth.password = password;
    this.auth.username = userName;
    this.userService.
    authentificateUser(this.auth).subscribe(data => {
                        this.value = data;
                        this.store(this.value.token);
                        this.setAuthentificationForUser(data); });
    this.router.navigate(['/home']);
  }


setAuthentificationForUser(res: AuthentificationResponse) {
   this.store(res.token);
   this.userService.getHome(res).subscribe( data =>{this.homeResponse = data;});
}

private store(content: Object) {
  localStorage.setItem(this.tokenKey, JSON.stringify(content));
}

private retrieve() {
  const storedToken: string = localStorage.getItem(this.tokenKey);
  if (!storedToken) {
      console.log('no token found');
  }
  return storedToken;
}

}
