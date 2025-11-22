import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IssueService } from '../../services/issue.service';
import { Issue } from '../../models/issue';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-create-issue',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './create-issue.component.html',
  styleUrls: ['./create-issue.component.css']
})
export class CreateIssueComponent {

  // AVAILABLE ASSIGNEES LIST
  assigneesList: string[] = [
    "Suvidha Sharma",
    "Sumita Gupta",
    "Rahul Tripathi",
    "Amit Joshi",
    "Pooja Deshmukh",
    "Rohan Patil",
  ];

  // INITIAL ISSUE OBJECT
  issue: Issue = {
    title: '',
    description: '',
    priority: '',
    status: '',
    assignee: ''
  };

  constructor(private issueService: IssueService) {}

  onSubmit() {
    this.issueService.createIssue(this.issue).subscribe({
      next: (res) => {
        alert("Issue created successfully!");

        // Reset form (CORRECT)
        this.issue = {
          title: '',
          description: '',
          priority: '',
          status: '',
          assignee: ''
        };
      },
      error: (err) => {
        alert("Something went wrong!");
        console.error(err);
      }
    });
  }
}
