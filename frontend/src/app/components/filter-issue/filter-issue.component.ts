import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IssueService } from '../../services/issue.service';

@Component({
  selector: 'app-filter-issue',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './filter-issue.component.html',
  styleUrls: ['./filter-issue.component.css']
})
export class FilterIssueComponent {

  priorityList = ['low', 'medium', 'high'];
  statusList = ['open', 'in_progress', 'resolved', 'closed'];

  selectedPriority = '';
  selectedStatus = '';

  filteredIssues: any[] = [];

  constructor(private issueService: IssueService) {}

  filterByPriority() {
    if (this.selectedPriority) {
      this.issueService.findByPriority(this.selectedPriority)
        .subscribe(data => this.filteredIssues = data);
    }
  }

  filterByStatus() {
    if (this.selectedStatus) {
      this.issueService.findByStatus(this.selectedStatus)
        .subscribe(data => this.filteredIssues = data);
    }
  }

  filterByBoth() {
    if (this.selectedPriority && this.selectedStatus) {
      this.issueService.findByPriorityAndStatus(this.selectedPriority, this.selectedStatus)
        .subscribe(data => this.filteredIssues = data);
    }
  }
}
