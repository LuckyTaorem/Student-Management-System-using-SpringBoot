package com.taorem.StudentManagementSystem;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(int id) {
        super("Student not found with ID: " + id);
    }
}
