import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { RoleComponent } from './role/role.component';
import { UserComponent } from './user/user.component';
import { RoleListComponent } from './role/rolelist.component';
import { UserListComponent } from './user/userlist.component';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'welcome',
    pathMatch: 'full'
  },

  {
    path: 'welcome',
    component: WelcomeComponent
  },

  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'signup',

    component: SignupComponent
  },

  {
    path: 'role',

    component: RoleComponent

  },
  {
    path:'user',
    component:UserComponent
  },
  {
    path: 'rolelist',
    component: RoleListComponent
  },
  {
    path: 'userList',
    component: UserListComponent
  },
  {
    path: 'user/:id',
    component: UserComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
