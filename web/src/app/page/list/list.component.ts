import { Component, OnInit } from '@angular/core';
import {Item, ItemService} from "../../service/item.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.less']
})
export class ListComponent implements OnInit {

  itemService: ItemService
  itemList: Item[] | null = null
  constructor(itemService: ItemService) {
    this.itemService = itemService
    itemService.getItems()
      .subscribe(it=>{
        this.itemList = it
      })
  }

  ngOnInit(): void {
  }

  delete(id: number) {
    this.itemService.deleteItems(id)
      .subscribe(it=>{
        this.itemService.getItems().subscribe(newList=>{
          this.itemList = newList
          alert(`Item[${id}] delete: ${it}`)
        })
      })
  }
}
