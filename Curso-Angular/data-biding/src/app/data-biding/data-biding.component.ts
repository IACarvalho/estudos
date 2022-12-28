import { Component } from '@angular/core'

@Component({
  selector: 'app-data-biding',
  templateUrl: './data-biding.component.html',
  styleUrls: ['./data-biding.component.css']
})
export class DataBidingComponent {

  url: string = 'http://loiane.com'
  cursoAngular: boolean = true
  urlImage: string = 'https://picsum.photos/seed/picsum/400/200'
  valorAtual: string = ''
  valorSalvo: string = ''
  isMouseOver: boolean = false
  nome: string = 'Israel'
  pessoa: any =  {
    name: '',
    age: 0
  }

  getValor(): number {
    return 1
  }

  getCurtirCurso(): boolean {
    return true
  }

  botaoClicado(): void {
    alert('Botão clucado!')
  }

  onKeyUp(event: KeyboardEvent): void{
    this.valorAtual = (<HTMLInputElement>event.target).value
  }
  salvarValor(value: string) : void {
    this.valorSalvo = value
  }

  onMouseOverOut(): void {
    this.isMouseOver = !this.isMouseOver
  }

  setNome(value: string): void {
    this.nome = value
  }

}
