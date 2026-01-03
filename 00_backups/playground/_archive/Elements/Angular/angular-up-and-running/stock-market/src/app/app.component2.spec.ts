import { TestBed, async } from '@angular/core/testing';

import { AppComponent } from './app.component';
import { StockItemComponent } from './stock/stock-item/stock-item.component';
import { Stock } from './model/stock';
import { By } from '@angular/platform-browser';
import { RouterOutlet } from '@angular/router';

describe('AppComponent', () => {

    describe('Simple, No Angular Unit Test', () => {
        /** Move all the previous test code into a
            child describe block
        */
    });

    describe('Angular-Aware test', () => {

        let fixture, component;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                declarations: [
                    AppComponent,
                    StockItemComponent,
                ],
            }).compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(AppComponent);
            component = fixture.componentInstance;
            fixture.detectChanges();
        });
        it('should load stock with default values', () => {
            const titleEl = fixture.debugElement.query(By.css('h1'));
            // Trim to avoid HTML whitespaces
            expect(titleEl.nativeElement.textContent.trim())
                .toEqual('Hello World!');

            // Check for default stock values in template
            const nameEl = fixture.debugElement.query(By.css('.name'));
            expect(nameEl.nativeElement.textContent)
                .toEqual('Test Stock Company (TSC)');
            const priceEl = fixture.debugElement.query(By.css('.positive'));
            expect(priceEl.nativeElement.textContent).toEqual(' $ 85 ');
            const addToFavoriteBtnEl = fixture.debugElement.query(By.css('button'));
            expect(addToFavoriteBtnEl).toBeDefined();
        });

        // it('should toggle stock favorite correctly', () => {
        //     expect(component.stockArr[0].favorite).toBeFalsy();
        //     let addToFavoriteBtnEl = fixture.debugElement.query(By.css('button'));
        //     expect(addToFavoriteBtnEl).toBeDefined();
        //     addToFavoriteBtnEl.triggerEventHandler('click', null);

        //     fixture.detectChanges();
        //     expect(component.stock.favorite).toBeTruthy();
        //     addToFavoriteBtnEl = fixture.debugElement.query(By.css('button'));
        //     expect(addToFavoriteBtnEl).toBeNull();
        // });

    });

});