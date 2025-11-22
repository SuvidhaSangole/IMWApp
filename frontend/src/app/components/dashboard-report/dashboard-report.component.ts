import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { IssueService } from '../../services/issue.service';
import { Issue } from '../../models/issue';

@Component({
  selector: 'app-dashboard-report',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard-report.component.html',
  styleUrls: ['./dashboard-report.component.css']
})
export class DashboardReportComponent implements OnInit {

  issues: Issue[] = [];

  // Summary counts
  openCount = 0;
  closedCount = 0;
  highPriorityCount = 0;

  constructor(private issueService: IssueService) {}

  ngOnInit(): void {
    this.loadReportData();
  }

  loadReportData() {
    this.issueService.findAll().subscribe({
      next: (data: Issue[]) => {
        this.issues = data;

        // Compute summary data
        this.openCount = data.filter(i => i.status === 'OPEN').length;
        this.closedCount = data.filter(i => i.status === 'CLOSED').length;
        this.highPriorityCount = data.filter(i => i.priority === 'HIGH').length;
      },
      error: () => {
        alert("Failed to load report data.");
      }
    });
  }
}
