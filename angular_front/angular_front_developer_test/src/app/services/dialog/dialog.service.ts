import { Dialog } from '@angular/cdk/dialog';
import { Injectable } from '@angular/core';
import { DialogComponent } from 'src/app/components/dialog-component/dialog-component.component';

@Injectable({
  providedIn: 'root',
})
export class DialogService {
  constructor(private dialog: Dialog) {}
  openDialog(title: String, message: String) {
    const dialogRef = this.dialog.open<string>(DialogComponent, {
      width: '250px',
      data: { title: title, message: message },
    });
  }
}
