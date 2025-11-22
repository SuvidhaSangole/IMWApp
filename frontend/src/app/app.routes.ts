import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CreateIssueComponent } from './components/create-issue/create-issue.component';
import { IssueListComponent } from './components/issue-list/issue-list.component';
import { UpdateIssueComponent } from './components/update-issue/update-issue.component';
import { DashboardReportComponent } from './components/dashboard-report/dashboard-report.component';
import { FindIssueComponent } from './components/find-issue/find-issue.component';
export const routes: Routes = [
   { path: '', component: DashboardComponent },
  { path: 'create-issue', component: CreateIssueComponent },
  { path: 'issue-list', component: IssueListComponent },
  { path: 'edit/:id', component: UpdateIssueComponent },
  { path: 'dashboard-report', component: DashboardReportComponent },

{
  path: "find-issue",
  loadComponent: () =>
    import('./components/find-issue/find-issue.component')
      .then(m => m.FindIssueComponent)
}

];
