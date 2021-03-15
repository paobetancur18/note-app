import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';
import {Note} from "./Note";
import {Injectable} from "@angular/core";

@Injectable()
export class NoteService{

    private url = '/api/note';
    
    constructor(private http: HttpClient){
    }

    getlAllNotes(): Observable<Note[]> {
        return this.http.get<Note[]>(`${this.url}/get-all-notes`);//this.http.get<Note[]>(url:this.url +"/get-all-notes");
    }

    save(note: Note): Observable<Object>{
        return this.http.post(`${this.url}/create-note`, note);
    }
}