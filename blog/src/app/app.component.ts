import { Component } from '@angular/core';
import { BlogEntry } from './blog-entry';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  blogEntries = [];

  constructor() { 
    this.blogEntries.push(new BlogEntry("Title 1", "Content 1"));
    this.blogEntries.push(new BlogEntry("Title 2", "Content 2"));
    this.blogEntries.push(new BlogEntry("Title 3", "Content 3"));
  }
}
