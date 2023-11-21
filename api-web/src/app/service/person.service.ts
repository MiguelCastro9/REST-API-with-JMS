import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Person } from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  api_url = environment.api_url;

  constructor(private http: HttpClient) { }

  public save(person: Person){
    return this.http.post<Person>(this.api_url + '/save', person);
  }

  list(){
    return this.http.get<Person[]>(this.api_url + '/list');
  }

  find(id: any){
    return this.http.get<Person>(this.api_url + '/find/' + id);
  }

  update(id: any, person: Person){
    return this.http.put<Person>(this.api_url + '/update/' + id, person);
  }

  delete(id: any){
    return this.http.delete<Person>(this.api_url + '/delete/' + id);
  }
}
