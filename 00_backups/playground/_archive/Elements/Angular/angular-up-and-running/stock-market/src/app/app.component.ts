import { Component, OnInit } from '@angular/core';
import { Stock } from './model/stock';

@Component({
  selector: 'flx-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'stock-market';

  public stockArr: Array<Stock>;

  ngOnInit(): void {
    this.stockArr = [
        new Stock('Test Stock Company', 'TSC', 85, 80),
        new Stock('Another Stock Company', 'ASC', 70, 72)
    ];
  }
  onToggleFavorite(stock: Stock) {
    console.log('Favorite for stock ', stock, ' was triggered');
    stock.favorite = !stock.favorite;
  }
}
