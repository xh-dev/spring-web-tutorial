import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface Item {
  id: number,
  name: string
}

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  http: HttpClient
  constructor(http: HttpClient) {
    this.http = http
  }

  getItems(): Observable<Item[]>{
    return this.http.get<Item[]>("http://localhost:8080/api/v1/some")
  }

  addItems(item: Item): Observable<Item>{
    return this.http.post<Item>("http://localhost:8080/api/v1/some", item)
  }

  deleteItems(itemNumber: number): Observable<string>{
    return this.http.delete<string>(`http://localhost:8080/api/v1/some/${itemNumber}`)
  }

}
