import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { HttpParams } from '@angular/common/http';
@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {
  createItemVisible:boolean = false;
  deleteItemVisible:boolean = false;
  readItemVisible:boolean = false;
  depositQuantityVisible:boolean = false;
  winthdrawQuantityVisible:boolean = false;
  alertMessage:string ="Result will appear here.";
  emptyField:string = "One or more of the fields is empty!";
  constructor(private userService:UserService) { 
  }
  
  ngOnInit(): void {
  }

  /*
  All these functions are for displaying the forms for each operation.
  */

  onSubmit(f:NgForm): void {

  }
  showCreateItemForm():void{
    this.resetVars();
    this.createItemVisible = !(this.createItemVisible);
  }
  showDeleteItemForm():void{
    this.resetVars();
    this.deleteItemVisible = !(this.deleteItemVisible);
  }
  showReadItemForm():void{
    this.resetVars();
    this.readItemVisible = !(this.readItemVisible);
  }
  showDepositForm():void{
    this.resetVars();
    this.depositQuantityVisible = !(this.depositQuantityVisible);
  }
  showWithdrawForm():void{
    this.resetVars();
    this.winthdrawQuantityVisible = !(this.winthdrawQuantityVisible);
  }

  /*
  This is intended to reset all the boolean vars so no duplicate form wil be seen.
  */

  resetVars():void{
    this.createItemVisible = false;
    this.deleteItemVisible = false;
    this.depositQuantityVisible= false;
    this.readItemVisible= false;
    this.winthdrawQuantityVisible =false;
  }

  /*
  All the form functions which will send the HTTP request.
  */

  checkIfFormValid(form:NgForm):boolean{
    if (form.invalid){
      this.alertMessage = this.emptyField;
      return false;
    }
    return true;
  }
 
  onReadSubmit(form:NgForm):any {
    var id = form.value.Read;
    if (!this.checkIfFormValid(form)){
      return;
    }
    this.userService.get_item(id).subscribe((data:any) => {
      if (data.error == true){
        alert('Error!');
      }else{
        this.alertMessage= "The user: " + data.item_no + "\n" +"Amount is: " + data.amount +"\n" +"Inventory code is: " + data.inventory_code;
      }
    },
    err => {
      this.alertMessage = err.error.message;
    },
    );
  }

  onCreateSubmit(form:NgForm):any{
    if (!this.checkIfFormValid(form)){
      return;
    }
    var name = form.value.Name;
    var amount = form.value.Amount;
    var inventory_code = form.value.Inventory_Code;
    this.userService.create_item(amount,inventory_code,name).subscribe((data:any) => {
      if (data.error == true){
        alert('Error!');
      }else{
        this.alertMessage = "Item has been created!"+ "\n"+ "item_no is: " + data.item_no
      }
    },
    err => {
      this.alertMessage = err.error.message;
    },
    );

  }

  onDeleteSubmit(form:NgForm):any{
    if (!this.checkIfFormValid(form)){
      return;
    }
    var id = form.value.Delete;
    this.userService.delete_item(id).subscribe((data:any) => {
      if (data.error == true){
        alert('Error!');
      }else{
        this.alertMessage ="Item has been deleted!" +"\n" +"Item_no: " + data.item_no;
      }
    },
    err => {
      this.alertMessage = err.error.message;
    },
    );
  }

  onDepositSubmit(form:NgForm):any{
    if (!this.checkIfFormValid(form)){
      return;
    }
    var id = form.value.Read;
    var amount = form.value.Amount;
      this.userService.deposit_quantity(id,amount).subscribe((data:any) => {
        if (data.error == true){
          alert('Error!');
        }else{
          this.alertMessage = "Deposit success!" +"\n" +"Current amount is: " +data.amount;
        }
      },
      err => {
        this.alertMessage = err.error.message;
      },
      );
  }

  onWithdrawSubmit(form:NgForm):any{
    if (!this.checkIfFormValid(form)){
      return;
    }
    var id = form.value.Read;
    var amount = form.value.Amount;
    this.userService.withdraw_quantity(id,amount).subscribe((data:any) => {
    if (data.error == true){
        alert('Error!');
      }else{
        this.alertMessage = "Withdraw success!" +"\n" +"Current amount is: " +data.amount;
      }
    },
      err => {
      this.alertMessage = err.error.message;
    },
    );
  }

  onShowItems():any{
    this.userService.read_all_items().subscribe((data:any) => {
    if (data.error == true){
        alert('Error!');
      }else{
        var msg = ""
        for (let i = 0; i<data.length; i++){
          msg += "Item no: " + data[i].item_no +"\n"+ "Amount: "+  +data[i].amount + "\n" + "Inventory code: " + data[i].inventory_code+"\n" +"---------------------" + "\n";
        }
        this.alertMessage = msg;
      }
    },
    err => {
      this.alertMessage = err.error.message;
    },
    );
  }
}
