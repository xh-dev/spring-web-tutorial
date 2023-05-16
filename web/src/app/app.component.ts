import { Component } from '@angular/core';
import {Item, ItemService} from "./service/item.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'web';
  description = "hello world"


  constructor(itemService: ItemService) {

  }

}
