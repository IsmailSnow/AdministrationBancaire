import { Component, OnInit } from '@angular/core';
import {IMyDpOptions} from 'angular4-datepicker/src/my-date-picker/interfaces';

@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.css']
})
export class DateComponent implements OnInit {

   public myDatePickerOptions: IMyDpOptions = {
        // other options...
        dateFormat: 'dd.mm.yyyy',
    };
 
    // Initialized to specific date (09.10.2018).
    public model: any = { date: { year: 2018, month: 10, day: 9 } };
 
    constructor() { }

  ngOnInit() {
  }

}
