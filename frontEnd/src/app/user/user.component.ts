import { UserModel } from './../model/user.model';
import { Component, OnInit } from '@angular/core';

import { UserService } from '../services/user.service';
declare var swal: any;//para alertas
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [UserService]
})
export class UserComponent implements OnInit {
  public lst_users: Array<UserModel>;//lista de usuarios
  public new_user: UserModel;//usuario insert
  public isValid: boolean = true;
  public isedit: boolean = false;
  public message: string = "A ocurrido un error en la transaccion";



  constructor(private _userService: UserService) {
    this.new_user = new UserModel();//inicializa variables
  }

  ngOnInit() {
    this.loadUsers();
  }

  private loadUsers(): void {
    this._userService.getUsers().subscribe(res => {
      this.lst_users = res;
      //console.log( res);
    });
  }
  public nuevo():void{
    this.new_user=new UserModel;
    this.isedit=false;
  }
  //actualizar
  public selectItemForUpdate(user:UserModel): void {
    this.new_user=user;
    this.isedit=true;
  }
  //insertar 
  public saveOrUpdate(): void {
    console.log(this.new_user);

    this._userService.saveOrUpdate(this.new_user).subscribe(res => {
      swal({
        title: "Transaccion!",
        text: res.message,
        icon: res.responcecode == 200 ? "success" : "error",
        button: "OK!",
      });
      this.loadUsers();
    });
  }
  //eliminar
  public eliminar(usuario: UserModel): void {
    console.log(usuario);


    swal({
      title: "Eliminar?",
      text: "Esta Seguro de Eliminar!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
      .then((willDelete) => {
        if (willDelete) {
          this._userService.eliminar(usuario).subscribe(res => {
            swal({
              title: "Eliminacion!",
              text: res.message,
              icon: res.responcecode == 200 ? "success" : "error",
              button: "OK!",
            });
            this.loadUsers();
          });
        } else {
          //  swal("canselo con exito!");
        }
      });
 

  }
}
