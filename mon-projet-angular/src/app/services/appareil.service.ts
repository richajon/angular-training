import { Subject } from 'rxjs';

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
}