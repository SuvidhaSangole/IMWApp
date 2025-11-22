import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { IssueService } from '../../services/issue.service';

@Component({
  selector: 'app-issue-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './issue-list.component.html',
  styleUrls: ['./issue-list.component.css']
})
export class IssueListComponent implements OnInit {

  issues: any[] = [];
  allIssues: any[] = [];   // ← required for filtering

  priorities = ['HIGH', 'MEDIUM', 'LOW'];
  statuses = ['OPEN', 'IN_PROGRESS', 'RESOLVED','CLOSED'];

  selectedPriority = "";
  selectedStatus = "";

  constructor(private issueService: IssueService) {}

  ngOnInit(): void {
    this.loadIssues();
  }

  loadIssues() {
    this.issueService.findAll().subscribe(data => {
      this.allIssues = data;
      this.issues = data;   // display all initially
    });
  }

  filterIssues() {
    this.issues = this.allIssues.filter(issue => {
      return (
        (this.selectedPriority === "" || issue.priority === this.selectedPriority) &&
        (this.selectedStatus === "" || issue.status === this.selectedStatus)
      );
    });
  }

  resetFilter() {
    this.selectedPriority = "";
    this.selectedStatus = "";
    this.issues = [...this.allIssues];
  }

  deleteIssue(id: number) {
    if (confirm("Are you sure you want to delete this issue?")) {
      this.issueService.deleteById(id).subscribe({
        next: () => {
          alert("Issue deleted successfully!");
          this.loadIssues();
        },
        error: () => alert("Failed to delete issue")
      });
    }
  }
}
