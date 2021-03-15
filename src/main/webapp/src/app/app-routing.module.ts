import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateNotesComponent } from './note/create-notes/create-notes.component';
import { ListNotesComponent } from './note/list-notes/list-notes.component';

const routes: Routes = [
  {path:'', redirectTo:'note/list', pathMatch:'full'},
  {path:'note/list', component: ListNotesComponent},
  {path:'note/create', component: CreateNotesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
