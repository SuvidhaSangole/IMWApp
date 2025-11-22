package com.imwapp.api.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imwapp.api.constant.IssuePriority;
import com.imwapp.api.constant.IssueStatus;
import com.imwapp.api.dao.IssueDao;
import com.imwapp.api.entity.Issue;
import com.imwapp.api.exceptions.ResourceNotFoundException;
import com.imwapp.api.service.IssueService;

import jakarta.validation.Valid;

@Service
public class IssueServiceImpl implements IssueService {
	private final IssueDao issueDao;

	IssueServiceImpl(IssueDao issueDao) {
		this.issueDao = issueDao;

	}

	@Override
	public Issue createIssue(Issue issue) {
		Issue createdIssue = issueDao.createIssue(issue);
		if (createdIssue == null) {
			throw new RuntimeException("Failed to create issue");
		} else {
			return createdIssue;
		}
	}

	@Override
	public Issue findById(long id) {
		Issue searchedIssue = issueDao.findById(id);
		if (searchedIssue == null) {
			throw new ResourceNotFoundException("Issue not found with id: " + id);
		}
		return searchedIssue;

	}

	

	@Override
	public List<Issue> findAll() {
		List<Issue> issuesList = issueDao.findAll();
		if (issuesList.isEmpty()) {
			throw new ResourceNotFoundException("No Issues found");
		}
		return issuesList;
	}

	@Override
	public List<Issue> findByPriority(IssuePriority priority) {
		List<Issue> issuesList = issueDao.findByPriority(priority);
		if (issuesList.isEmpty()) {
			throw new ResourceNotFoundException("Issue not found with priority: " + priority);
		}

		return issuesList;
	}

	@Override
	public List<Issue> findByStatus(IssueStatus status) {
		List<Issue> issuesList = issueDao.findByStatus(status);
		if (issuesList.isEmpty()) {
			throw new ResourceNotFoundException("Issue not found with status: " + status);
		}
		return issuesList;
	}

	@Override
	public List<Issue> findByPriorityAndStatus(IssuePriority priority, IssueStatus status) {
		List<Issue> issuesList = issueDao.findByPriorityAndStatus(priority, status);
		if (issuesList.isEmpty()) {
			throw new ResourceNotFoundException("No issues found with priority: " + priority + " and status: " + status);
		}

		return issuesList;
	}

	@Override
	public Issue updateIssue(long id, @Valid Issue newIssueDetails) {
		Issue existingIssue = issueDao.findById(id);
		if (existingIssue == null) {
			throw new ResourceNotFoundException("Issue not found with id: " + id);
		} else {
			existingIssue.setTitle(newIssueDetails.getTitle());
			existingIssue.setDescription(newIssueDetails.getDescription());
			existingIssue.setPriority(newIssueDetails.getPriority());
			existingIssue.setStatus(newIssueDetails.getStatus());
			existingIssue.setAssignee(newIssueDetails.getAssignee());
			Issue newUpdatedIssue = issueDao.updateIssue(existingIssue);
			return newUpdatedIssue;
		}

	}
	@Override
	public Issue deleteById(long id) {
		Issue deletedIssue = issueDao.findById(id);
		if (deletedIssue == null) {
			throw new ResourceNotFoundException("Issue not found with id: " + id);
		}else {
          deletedIssue=  issueDao.deleteById(id);
          }
		return deletedIssue;

	}


}
