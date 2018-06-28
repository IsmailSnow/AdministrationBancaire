import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../../user/user-model/userModel'; 
import {IMyDpOptions} from 'angular4-datepicker/src/my-date-picker/interfaces';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user: User;
  public myDatePickerOptions: IMyDpOptions = {
        dateFormat: 'dd.mm.yyyy',
    };
 public startDay: Date = new Date(2018, 10, 9);
  constructor() { }


  ngOnInit() {
  }

  resetForm(form?: NgForm) {
    form.reset();
    this.user.BirthDay = this.startDay;
  }

  OnSubmit(form: NgForm) { 
    console.log(form.value);
  }
}
