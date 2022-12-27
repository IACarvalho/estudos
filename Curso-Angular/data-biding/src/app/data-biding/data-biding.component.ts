import { Component } from '@angular/core';

@Component({
  selector: 'app-data-biding',
  templateUrl: './data-biding.component.html',
  styleUrls: ['./data-biding.component.css']
})
export class DataBidingComponent {

  url: string = 'http://loiane.com'
  cursoAngular: boolean = true
  urlImage: string = 'https://picsum.photos/seed/picsum/400/200'

  getValor(): number {
    return 1
  }

  getCurtirCurso(): boolean {
    return true
  }

}
