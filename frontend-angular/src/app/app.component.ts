import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  message = '';

  constructor(private http: HttpClient) {}

  sendMessage() {
    this.http.post('http://localhost:8080/api/messages', this.message, { responseType: 'text' })
      .subscribe({
    next: response => console.log(response),
    error: error => alert('Failed to send message!')
  });
}
}