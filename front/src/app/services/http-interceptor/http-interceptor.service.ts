import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const username = 'damian';
    const password = 'damian';
    const basicAuth = 'Basic ' + window.btoa(username + ':' + password);

    req = req.clone(
      {
        setHeaders: {
          Authorization: basicAuth
        }
      }
    );
    return next.handle(req);

  }


  constructor() { }
}
