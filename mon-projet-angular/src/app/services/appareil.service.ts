export class AppareilService {
    
  appareils = [
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

  switchOnAllAppareils() {
    for(let appareil of this.appareils) {
        appareil.status = 'Allume';
    }
  }

  switchOffAllAppareils() {
    for(let appareil of this.appareils) {
        appareil.status = 'Eteint';
    }
  }

  switchOnOne(index: number) {
      this.appareils[index].status = 'Allume';
  }

  switchOffOne(index: number) {
    this.appareils[index].status = 'Eteint';
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