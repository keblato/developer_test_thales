import { HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { ErrorHandler, Injectable, NgZone } from '@angular/core';
import { DialogService } from '../services';

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {
  constructor(private dialogService: DialogService, private zone: NgZone) {}

  handleError(error: any) {
    let title: String = 'An error has occurred!';
    let message: String = '';
    if (error instanceof HttpErrorResponse) {
      if (error.status === 0) {
        message = 'The server is not responding properly';
      } else if (error.status === HttpStatusCode.TooManyRequests) {
        message =
          'You have exceeded the allowed request limit in a short period. Please wait for a while before trying again.';
      } else if (error.status === HttpStatusCode.InternalServerError) {
        message =
          'An internal server error occurred while processing your request. Our technical team is working to fix it. Please try again later.';
      } else if (error.status === HttpStatusCode.BadRequest) {
        message =
          'The request you sent is incorrect or incomplete. Make sure all data is valid and try again.';
      } else {
        message = 'Something went wrong. Please try again later.';
      }
      this.zone.run(() => this.dialogService.openDialog(title, message));
    }

    console.error('Error from global error handler', error);
  }
}
