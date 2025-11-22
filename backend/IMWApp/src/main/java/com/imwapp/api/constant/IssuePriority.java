package com.imwapp.api.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IssuePriority {

	LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH");

	private final String value;

	IssuePriority(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
	
	@JsonCreator
    public static IssuePriority fromValue(String value) {
        for (IssuePriority priority : IssuePriority.values()) {
            if (priority.value.equalsIgnoreCase(value)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid Issue Priority: " + value);
    }

}
