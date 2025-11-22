import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IssueService } from '../../services/issue.service';
import { Issue } from '../../models/issue';

@Component({
  selector: 'app-find-issue',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './find-issue.component.html',
  styleUrls: ['./find-issue.component.css']
})
export class FindIssueComponent {

  issueId!: number;
  issue: Issue | null = null;
  errorMessage: string = '';
  loading: boolean = false;

  constructor(private issueService: IssueService) {}

  onSearch() {
    this.errorMessage = '';
    this.issue = null;

    if (!this.issueId) {
      this.errorMessage = "Please enter a valid Issue ID!";
      return;
    }

    this.loading = true;

    this.issueService.findById(this.issueId).subscribe({
      next: (res) => {
        this.issue = res;
        this.loading = false;
      },
      error: (err) => {
        this.loading = false;
        this.errorMessage = err.error.message || "Issue not found!";
      }
    });
  }
}
