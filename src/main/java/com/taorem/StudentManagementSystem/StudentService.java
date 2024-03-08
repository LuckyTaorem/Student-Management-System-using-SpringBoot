package com.taorem.StudentManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;

	public void addStudentForm(Student student) {
        studentRepository.save(student);
    }
	
    public String addStudent(Student student) {
    	if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            return "First Name is required";
        }
    	if (student.getLastName() == null || student.getLastName().isEmpty()) {
            return "Last Name is required";
        }
    	if (student.getStudentId() == 0) {
            return "Student Id is required";
        }
    	if (student.getCourse() == null || student.getCourse().isEmpty()) {
            return "Course is required";
        }
    	if (student.getDob() == null || student.getDob().isEmpty()) {
            return "Date of Birth is required";
        }
    	if (student.getCGPA() == 0.0) {
            return "CGPA is required ";
        }
        studentRepository.save(student);
        return "Student added successfully";
    }

    public String updateStudent(int id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElse(null);
        
        if(existingStudent==null) {
    		return "Student not found!";
    	}

        if (existingStudent.getFirstName() == null || existingStudent.getFirstName().isEmpty()) {
            return "First Name is required";
        }
    	if (existingStudent.getLastName() == null || existingStudent.getLastName().isEmpty()) {
            return "Last Name is required";
        }
    	if (existingStudent.getStudentId() == 0) {
            return "Student Id is required";
        }
    	if (existingStudent.getCourse() == null || existingStudent.getCourse().isEmpty()) {
            return "Course is required";
        }
    	if (existingStudent.getDob() == null || existingStudent.getDob().isEmpty()) {
            return "Date of Birth is required";
        }
    	if (existingStudent.getCGPA() == 0.0) {
            return "CGPA is required ";
        }
        existingStudent.setCourse(student.getCourse());
        existingStudent.setCGPA(student.getCGPA());
        existingStudent.setDob(student.getDob());
        studentRepository.save(student);
        return "Student Details Updated successfully";
    }
    
    public String updateStudentForm(Student student) {
    	Student existingStudent = studentRepository.findById(student.getStudentId())
                .orElse(null);
        
        if(existingStudent==null) {
        	return "StudentNotFound";
    	}
        existingStudent.setCourse(student.getCourse());
        existingStudent.setCGPA(student.getCGPA());
        existingStudent.setDob(student.getDob());
        studentRepository.save(student);
        return "Done";
    }

    public String deleteStudent(int id) {
    	Student student = studentRepository.findById(id)
                .orElse(null);
    	if(student==null) {
    		return "Student not found!";
    	}
        studentRepository.delete(student);
        return "Student Details deleted successfully";
    }
    
    public String deleteStudent2(int id) {
    	Student student = studentRepository.findById(id)
                .orElse(null);
    	if(student==null) {
    		return "Student not found!";
    	}
        studentRepository.delete(student);
        return "Student Details deleted successfully";
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    public Student getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return student;
    }
    
    public Student getStudentById2(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return student;
    }
}
