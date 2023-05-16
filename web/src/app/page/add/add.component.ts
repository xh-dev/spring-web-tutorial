import { Component, OnInit } from '@angular/core';
import {Item, ItemService} from "../../service/item.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.less']
})
export class AddComponent implements OnInit {

  itemService: ItemService
  router: Router
  constructor(itemService: ItemService, router: Router) {
    this.itemService = itemService
    this.router = router
  }

  name: string = ""
  ngOnInit(): void {
  }

  add() {
    if(this.name === ""){
      alert("name is empty")
      return
    }

    this.itemService.addItems({id: -1, name: this.name})
      .subscribe(it=>{
        alert("Add success")
        this.router.navigateByUrl("/list")
      })

  }
}
