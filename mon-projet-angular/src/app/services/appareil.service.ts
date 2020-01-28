import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';

@Injectable()
export class AppareilService {
  
  appareilSubject = new Subject<any[]>();

  private appareils = [
    {
      id: 1,
      name: 'Machine a laver',
      status: 'Eteint'
    },
    {
      id: 2,
      name: 'Television',
      status: 'Eteint'
    },
    {
      id: 3,
      name: 'Ordinateur',
      status: 'Allume'
    }
  ];

  constructor(private httpClient: HttpClient) {};

  emitAppareilSubject() {
    this.appareilSubject.next(this.appareils.slice());
  }

  switchOnAllAppareils() {
    for(let appareil of this.appareils) {
        appareil.status = 'Allume';
    }
    this.emitAppareilSubject();
  }

  switchOffAllAppareils() {
    for(let appareil of this.appareils) {
        appareil.status = 'Eteint';
    }
    this.emitAppareilSubject();
  }

  switchOnOne(index: number) {
      this.appareils[index].status = 'Allume';
      this.emitAppareilSubject();
  }

  switchOffOne(index: number) {
    this.appareils[index].status = 'Eteint';
    this.emitAppareilSubject();
  }

  getAppareilById(id: number) {
      const appareil = this.appareils.find(
          (appareilObject) => {
              return appareilObject.id === id;
          }
      );
      return appareil;
  }

  addAppareil(name: string, status: string) {
    const appareilObject = {
      id: 0,
      name: '',
      status: ''
    }
    appareilObject.name = name;
    appareilObject.status = status;
    appareilObject.id = this.appareils[(this.appareils.length-1)].id + 1;
 
    this.appareils.push(appareilObject);
    this.emitAppareilSubject();
  }

  saveAppareilsToServer() {
    this.httpClient.put('http://localhost:8080/backend-rest/appareils', this.appareils)
    .subscribe(
      () => {
        console.log("Enregistrement termine. ");
      },
      (error) => {
        console.log("Erreur de sauvegarde: " + error);
      }
    )
  }

  getAppareilsFromServer() {
    this.httpClient.get<any>('http://localhost:8080/backend-rest/appareils').subscribe(
      (response) => {
        this.appareils = response;
        this.emitAppareilSubject();
      },
      (error) => {
        console.log("Erreur de chargement: " + error);
      }
    ) 
  }
}