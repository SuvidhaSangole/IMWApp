export interface Issue {
  id?: number;
  title: string;
  description: string;
  priority: string;   // "low" | "medium" | "high"
  status: string;     // "open" | "in_progress" | "resolved" | "closed"
  assignee: string;

  createdDate?: string;     // comes from backend
  updatedDate?: string; 
}
