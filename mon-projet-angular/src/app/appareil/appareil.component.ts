import { Component, OnInit, Input } from '@angular/core';
import { AppareilService } from '../services/appareil.service';

@Component({
  selector: 'app-appareil',
  templateUrl: './appareil.component.html',
  styleUrls: ['./appareil.component.scss']
})
export class AppareilComponent implements OnInit {

  @Input() appareilName: string;
  @Input() appareilStatus: string;
  @Input() indexOfAppareil: number;
  @Input() id: number;

  constructor(private AppareilService: AppareilService) { }

  ngOnInit() {
  }

  getStatus() {
    return this.appareilStatus;
  }

  getColor() {
    if (this.appareilStatus === "Eteint") {
      return "red";
    } else if (this.appareilStatus === "Allume") {
      return "green";
    }
  }

  onSwitchOn() {
    this.AppareilService.switchOnOne(this.indexOfAppareil);
  }

  onSwitchOff() {
    this.AppareilService.switchOffOne(this.indexOfAppareil);
  }
}
