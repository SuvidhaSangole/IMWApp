package com.imwapp.api.service;

import java.util.List;

import com.imwapp.api.constant.IssuePriority;
import com.imwapp.api.constant.IssueStatus;
import com.imwapp.api.entity.Issue;

import jakarta.validation.Valid;

public interface IssueService {

	public abstract Issue createIssue(Issue issue);
	public abstract Issue findById(long id);
	public abstract List<Issue> findAll();
	public abstract Issue deleteById(long id);
	public abstract List<Issue> findByPriority(IssuePriority priority);
	public abstract List<Issue> findByStatus(IssueStatus status);
	public abstract List<Issue> findByPriorityAndStatus(IssuePriority priority, IssueStatus status);
	public abstract Issue updateIssue(long id, @Valid Issue issueDetails);


}
