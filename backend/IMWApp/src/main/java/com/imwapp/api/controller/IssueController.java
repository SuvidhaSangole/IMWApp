package com.imwapp.api.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imwapp.api.constant.IssuePriority;
import com.imwapp.api.constant.IssueStatus;
import com.imwapp.api.entity.Issue;
import com.imwapp.api.service.IssueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/issues")
public class IssueController {
	private final IssueService issueService;

	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@PostMapping("/createIssue")
	public ResponseEntity<Issue> createIssue(@Valid @RequestBody Issue issue) {
		Issue createdissue = issueService.createIssue(issue);
		return ResponseEntity.status(201).body(createdissue);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Issue> findById(@PathVariable long id) {
		Issue searchedIssue = issueService.findById(id);
		return ResponseEntity.ok(searchedIssue);
	}

	@GetMapping("/findAll")
	public List<Issue> findAll() {

		return issueService.findAll();
	}

	

	@GetMapping("/findByPriority/{priority}")
	public List<Issue> findByPriority(@PathVariable IssuePriority priority) {
		return issueService.findByPriority(priority);
	}

	@GetMapping("/findByStatus/{status}")
	public List<Issue> findByStatus(@PathVariable IssueStatus status) {
		return issueService.findByStatus(status);
	}

	@GetMapping("/findByPriorityAndStatus/{priority}/{status}")
	public List<Issue> findByPriorityAndStatus(@PathVariable IssuePriority priority, @PathVariable IssueStatus status) {
		return issueService.findByPriorityAndStatus(priority, status);
	}

	// update issue
	@PutMapping("/updateIssue/{id}")
	public ResponseEntity<Issue> updateIssue(@PathVariable long id, @Valid @RequestBody Issue issueDetails) {
		Issue updatedIssue = issueService.updateIssue(id, issueDetails);
		return ResponseEntity.ok(updatedIssue);

	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Issue> deleteById(@PathVariable long id) {
		Issue deletedIssue = issueService.deleteById(id);
		return ResponseEntity.ok(deletedIssue);
	}

}
