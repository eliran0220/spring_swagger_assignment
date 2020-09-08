import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders, HttpResponse} from '@angular/common/http'
import { mergeMap} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  root = "http://localhost:8080/"
  constructor(private http: HttpClient)  { }

  get_item(item_no) {
    return this.http.get(this.root + "api/items/getItem?itemId=" + item_no);
  }

  read_all_items(){
    return this.http.get(this.root+"api/items");
  }
  create_item(amount,inventory_code,name){
    const ParseHeaders = {
      headers: new HttpHeaders({
       'Content-Type'  : 'application/x-www-form-urlencoded'
        
      })
     };
    let data = "amount=" + ''+amount + "&inventory_code=" + ''+inventory_code + "&name=" + name;
    return this.http.post(this.root +"api/items/add?",data,ParseHeaders);
  }

  delete_item(item_no) {
    return this.http.delete(this.root+"/api/items/delete?item_no=" + item_no);
  }

  deposit_quantity(item_no,amount){
    const ParseHeaders = {
      headers: new HttpHeaders({
       'Content-Type'  : 'application/x-www-form-urlencoded'
      })
     };
     let data = "item_no=" +item_no + "&quantity=" +''+amount;
    return this.http.put(this.root+"api/items/deposit?",data,ParseHeaders);
  }

  withdraw_quantity(item_no,amount){
    const ParseHeaders = {
      headers: new HttpHeaders({
       'Content-Type'  : 'application/x-www-form-urlencoded'
      })
     };
     let data = "item_no=" +item_no + "&quantity=" +''+amount;
    return this.http.put(this.root+"api/items/withdraw?",data,ParseHeaders);
  }




  
}