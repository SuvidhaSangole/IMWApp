package com.imwapp.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueDto {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private String priority; // LOW/MEDIUM/HIGH
    private String status; // OPEN/IN_PROGRESS/RESOLVED/CLOSED
    private String assignee;
    // getters/setters
}
