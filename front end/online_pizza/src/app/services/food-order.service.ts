import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FoodOrder } from '../class/food-order';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class FoodOrderService {

  addEmpURL : string;
  getEmpURL : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;

  constructor(private http : HttpClient) {

    this.addEmpURL = 'http://localhost:8086/postfood-order';
    this.getEmpURL = 'http://localhost:8086/food-order';
    this.updateEmpUrl = 'http://localhost:8086/updatefood-order';
    this.deleteEmpUrl = 'http://localhost:8086/deletefood-order';

   }

   addFoodOrder(foodorder : FoodOrder): Observable<FoodOrder> {
     return this.http.post<FoodOrder>(this.addEmpURL,foodorder);
   }

   getAllFoodOrder(): Observable<FoodOrder[]>{
     return this.http.get<FoodOrder[]>(this.getEmpURL);
   }

   updateFoodOrder(foodorder :FoodOrder) : Observable<FoodOrder>{
     return this.http.put<FoodOrder>(this.updateEmpUrl, foodorder);
   }
   
  findAll(): Observable<any> {
    console.log(FoodOrder)
    return this.http.get('http://localhost:8086/room');
  }

   deleteFoodOrder(foodorder : FoodOrder) : Observable<FoodOrder> {
     return this.http.delete<FoodOrder>(this.deleteEmpUrl+'/'+foodorder.orderId);
   }
  

}