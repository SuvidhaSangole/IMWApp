import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { IssueService } from '../../services/issue.service';
import { Issue } from '../../models/issue';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-issue',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './update-issue.component.html',
  styleUrls: ['./update-issue.component.css']
})
export class UpdateIssueComponent implements OnInit {

  issueId!: number;

  // ✅ FIX: Move assignees here — OUTSIDE the issue object
  assignees: string[] = [
    "Suvidha Sharma",
    "Sumita Gupta",
    "Rahul Tripathi",
    "Amit Joshi",
    "Pooja Deshmukh",
    "Rohan Patil"
  ];

  issue: Issue = {
    id: 0,
    title: '',
    description: '',
    priority: '',
    status: '',
    assignee: ''
  };

  loading = true;

  constructor(
    private route: ActivatedRoute,
    private issueService: IssueService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.issueId = Number(this.route.snapshot.paramMap.get('id'));

    this.issueService.findById(this.issueId).subscribe({
      next: (res) => {
        this.issue = res;
        this.loading = false;
      },
      error: (err) => {
        console.error(err);
        alert("Failed to load issue");
        this.loading = false;
      }
    });
  }

  updateIssue() {
    this.issueService.updateIssue(this.issueId, this.issue).subscribe({
      next: () => {
        alert("Issue Updated Successfully!");
        this.router.navigate(['/issue-list']);
      },
      error: (err) => {
        console.error(err);
        alert("Update failed");
      }
    });
  }

  goBack() {
    this.router.navigate(['/issue-list']);
  }
}
