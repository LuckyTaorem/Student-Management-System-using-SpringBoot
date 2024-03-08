package com.taorem.StudentManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.ui.Model;

@Controller
public class StudentController {

	@Autowired
    private StudentService studentService;
	
	@PostMapping("/student/new")
    public String addStudentForm(@ModelAttribute Student student) {
    	studentService.addStudentForm(student);
        return "redirect:/?query=You%20have%20added%20student%20details%20Successfully!!!";
  }
	
    @PostMapping("/api/student/new")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        String message = studentService.addStudent(student);
    	return ResponseEntity.ok(message);
    }
    
    @GetMapping("/api/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
    	Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
    }
    
    @GetMapping("/student/")
    public ResponseEntity<Student> getStudentById2(@RequestParam int id) {
    	Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
    }

    @PutMapping("/api/student/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
    	 String message = studentService.updateStudent(id,student);
     	return ResponseEntity.ok(message);
    }
    
    @PostMapping("/student/update")
    public String updateStudentForm(@ModelAttribute Student student) {
    	 String message = studentService.updateStudentForm(student);
    	 if(message.equals("StudentNotFound")) {
    		 return "redirect:/?error=Student%20Not%20Found";
    	 }
    	 return "redirect:/?query=You%20have%20Updated%20student%20details%20Successfully!!!";
    }

    @DeleteMapping("/api/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
    	String message = studentService.deleteStudent(id);
     	return ResponseEntity.ok(message);
    }
    
    @GetMapping("/student/delete/")
    public ResponseEntity<String> deleteStudent2(@RequestParam int id) {
    	String message = studentService.deleteStudent(id);
     	return ResponseEntity.ok(message);
    }

    @GetMapping("/api/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    
    @GetMapping("/student")
    public String getAllStudents2(Model model) {
    	model.addAttribute("student",studentService.getAllStudents());
        return "redirect:/";
    }
    
    
    @GetMapping("/help")
    public String help(Model model) {
    	final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    	model.addAttribute("url", baseUrl+"/");
        return "help";
    }
    
    @GetMapping("/")
    public String index(Model model) {
    	final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    	model.addAttribute("url", baseUrl+"/");
        return "index";
    }
}
