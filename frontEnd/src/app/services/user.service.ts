import { UserModel } from './../model/user.model';
import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { ResponseModel } from './../model/restResponse.model';
import {GLOBAL} from './global';
@Injectable()
export class UserService {


  constructor(private _http: HttpClient) { }
  public getUsers(): Observable<UserModel[]> {
   return this._http.get<UserModel[]>(GLOBAL.url+"/users");
  }
    public saveOrUpdate(user:UserModel): Observable<ResponseModel> {
      return this._http.post<ResponseModel>(GLOBAL.url+"/saveOrUpdate",user);
    }
    public eliminar(user:UserModel): Observable<ResponseModel> {
      return this._http.post<ResponseModel>(GLOBAL.url+"/deleteUser",user);
    }

}
