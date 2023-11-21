import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Person } from '../model/person';
import { Notifications } from '../model/notifications';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  api_url = environment.api_url;

  constructor(private http: HttpClient) { }

  public save(person: Person) {
    return this.http.post<Person>(this.api_url + '/save', person);
  }

  public list() {
    return this.http.get<Person[]>(this.api_url + '/list');
  }

  public find(id: any) {
    return this.http.get<Person>(this.api_url + '/find/' + id);
  }

  public update(id: any, person: Person) {
    return this.http.put<Person>(this.api_url + '/update/' + id, person);
  }

  public delete(id: any) {
    return this.http.delete<Person>(this.api_url + '/delete/' + id);
  }

  public getNotifications() {
    return this.http.get<Notifications[]>(this.api_url + '/notifications');
  }
}
