import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Issue } from '../models/issue';

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  private BASE_URL = 'http://localhost:8091/api/issues';

  constructor(private http: HttpClient) {}

  getAllIssues() {
  return this.http.get<Issue[]>(`${this.BASE_URL}`);
}

  createIssue(issue: Issue): Observable<Issue> {
    return this.http.post<Issue>(`${this.BASE_URL}/createIssue`, issue);
  }

  findById(id: number): Observable<Issue> {
    return this.http.get<Issue>(`${this.BASE_URL}/findById/${id}`);
  }


  findAll(): Observable<Issue[]> {
    return this.http.get<Issue[]>(`${this.BASE_URL}/findAll`);
  }

  deleteById(id: number): Observable<Issue> {
    return this.http.delete<Issue>(`${this.BASE_URL}/deleteById/${id}`);
  }

  findByPriority(priority: string): Observable<Issue[]> {
    return this.http.get<Issue[]>(`${this.BASE_URL}/findByPriority/${priority}`);
  }

  findByStatus(status: string): Observable<Issue[]> {
    return this.http.get<Issue[]>(`${this.BASE_URL}/findByStatus/${status}`);
  }

  findByPriorityAndStatus(priority: string, status: string): Observable<Issue[]> {
    return this.http.get<Issue[]>(`${this.BASE_URL}/findByPriorityAndStatus/${priority}/${status}`);
  }

  updateIssue(id: number, issue: Issue): Observable<Issue> {
    return this.http.put<Issue>(`${this.BASE_URL}/updateIssue/${id}`, issue);
  }
}
