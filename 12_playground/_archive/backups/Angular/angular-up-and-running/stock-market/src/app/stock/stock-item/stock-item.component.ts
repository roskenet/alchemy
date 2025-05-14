import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectionStrategy } from '@angular/core';
import { Stock } from '../../model/stock';

@Component({
  selector: 'flx-stock-item',
  templateUrl: './stock-item.component.html',
  styleUrls: ['./stock-item.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class StockItemComponent {

  @Input()
  public stocks: Array<Stock>;
  @Output()
  private toggleFavorite: EventEmitter<Stock>;
  public stockClasses;

  constructor() { 
    this.toggleFavorite = new EventEmitter<Stock>();
  }

  trackStockByCode(index, stock) {
    return stock.code;
  }

  onToggleFavorite(event, index: number) {
    console.log('Favorite for index ', index, ' was triggered');
    this.toggleFavorite.emit(this.stocks[index]);
  }

  changeStockPrice(index: number) {
    this.stocks[index].price += 5;
  }
}
