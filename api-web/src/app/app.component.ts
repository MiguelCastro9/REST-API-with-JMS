import { PersonService } from './service/person.service';
import { Person } from './model/person';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'api-web';

  person: Person = {
    id: '',
    name: '',
    birth_date: undefined
  };
  alertMessage = '';
  persons: Person[] = [];
  activeSave = true;
  activeUpdate = false;

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.list();
    this.activeSave = true;
  }

  validForm() {
    if(!this.person.name) {
      this.alertMessage = 'Name is required.';
      return false;
    }
    if(!this.person.birth_date) {
      this.alertMessage = 'Birth date is required.';
      return false;
    }
    return true;
  }

  public save(person: Person) {
    if (!this.validForm()) {
      return;
    }
    this.personService.save(person).subscribe(data => {
      this.list();
    })
  }

  public list() {
    this.activeSave = true;
    this.activeUpdate = false;
    this.personService.list().subscribe(data => {
      this.persons = data;
      this.person = {
        id: '',
        name: '',
        birth_date: undefined
      };
      this.alertMessage = '';
    });
  }

  getPerson(person: Person) {
    this.activeUpdate = true;
    this.activeSave = false;
    this.person = { ...person };
  }

  public update(person: Person) {
    if (!this.validForm()) {
      return;
    }
    this.personService.update(person.id, person).subscribe(data => {
      this.list();
    })
  }

  public delete(id: any) {
    this.personService.delete(id).subscribe(data => {
      this.list();
    })
  }
}
