import { Component } from '@angular/core';
import { CursosService } from './cursos.service';



@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {
  htmlCurso: string;
  nomeDoPortal: string;
  cursos: string[] = []

  constructor(private cursosServie: CursosService) {
    this.htmlCurso = 'http://loiane.training';
    this.nomeDoPortal = 'Loraine Training'

    this.cursos = this.cursosServie.getCursos()

  }
}
