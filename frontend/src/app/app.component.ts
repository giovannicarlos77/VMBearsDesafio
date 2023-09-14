import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

/**
 * https://medium.com/@tarekabdelkhalek/how-to-create-a-drag-and-drop-file-uploading-in-angular-78d9eba0b854
 */

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'TesteVMBears';
  files: File[] = [];
  showProgressBar = false; 
  progressMessage = 'Arquivos sendo processados...';

  constructor(private http: HttpClient) {}

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;

    if (input.files) {
      for (let index = 0; index < input.files.length; index++) {
        this.files.push(input.files[index]);
      }
    }
  }

  onFileRemove(file: File): void {
    const index = this.files.indexOf(file);
    this.files.splice(index, 1);
  }

  onFileDropped(files: File[]): void {
    for (let index = 0; index < files.length; index++) {
      this.files.push(files[index]);
    }
  }

  sendFiles(): void {
    this.showProgressBar = true;
    const formData = new FormData();
  
    for (const file of this.files) {
      formData.append('files', file, file.name);
    }
  
    this.http
      .post('http://localhost:8080/process-xml', formData)
      .subscribe({
        next: (response) => {
          console.log('Response from server:', response);
          this.showProgressBar = false;
        },
        error: (error) => {
          this.showProgressBar = false;
          return throwError(() => new Error(error));
        },
      });
    }
}
