package com.imwapp.api.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;
	

	public enum IssueStatus {
	    OPEN("OPEN"),
	    IN_PROGRESS("IN_PROGRESS"),
	    RESOLVED("RESOLVED"),
	    CLOSED("CLOSED");

	    private final String value;

	    IssueStatus(String value) {
	        this.value = value;
	    }

	    @JsonValue
	    public String getValue() {
	        return value;
	    }

	    @JsonCreator
	    public static IssueStatus fromValue(String value) {
	        for (IssueStatus status : IssueStatus.values()) {
	            if (status.value.equalsIgnoreCase(value)) {
	                return status;
	            }
	        }
	        throw new IllegalArgumentException("Invalid Issue Status: " + value);
	    }
	}


