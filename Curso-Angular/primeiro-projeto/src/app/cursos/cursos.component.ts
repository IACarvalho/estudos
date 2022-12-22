import { Component } from '@angular/core';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {
  htmlCurso: string;
  nomeDoPortal: string;
  cursos: string[] = ['Java', 'Ext JS', 'Angular']

  constructor() {
    this.htmlCurso = 'http://loiane.training';
    this.nomeDoPortal = 'Loraine Training'
  }
}
