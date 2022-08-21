import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from '../service/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

data={
  to:"",
  subject:"",
  message:""
}




flag=false;              //used to hide / unhide the spinner 



  constructor(private email:EmailService , private snak:MatSnackBar) { }

  ngOnInit(): void {
  }

doSubmitForm()
{

  console.log("Try to submit form");
  console.log("DATA ", this.data);

if(this.data.to=='' || this.data.subject=='' || this.data.message=='' )
{
this.snak.open("fields can not be empty !! ","OK");         //TO sackbar dialog boas at the bottom middle of the page.
return;
}

   this.flag=true;                //enable the spinner
  this.email.sendEmail(this.data).subscribe(
    
  response=>{
console.log(response);
this.flag=false;

this.snak.open("Sent Mail SuccessFully ","OK");

  },
  error=>{
    console.log(error);
    this.flag=false;
    this.snak.open("Error ","Try Again");
  }

  )

}


}
