package com.imwapp.api.entity;

import java.time.LocalDateTime;

import com.imwapp.api.constant.IssuePriority;
import com.imwapp.api.constant.IssueStatus;

import jakarta.persistence.*;	
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Issue {
  
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private IssuePriority priority = IssuePriority.MEDIUM;

    @Enumerated(EnumType.STRING)
    private IssueStatus status = IssueStatus.OPEN;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private String assignee;

    // constructors, getters, setters
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        updatedDate = createdDate;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
