import { Component, OnInit, Input } from '@angular/core';
import { BlogEntry } from '../blog-entry';

@Component({
  selector: 'app-blog-entry',
  templateUrl: './blog-entry.component.html',
  styleUrls: ['./blog-entry.component.scss']
})
export class BlogEntryComponent implements OnInit {

  @Input() blogEntry: BlogEntry;

  constructor() { }

  ngOnInit() {
  }

  onLoveIt() {
    this.blogEntry.loveIts++;
  }

  onDontLoveIt() {
    this.blogEntry.loveIts--;
  }
}
