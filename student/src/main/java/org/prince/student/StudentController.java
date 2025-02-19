package org.prince.student;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/with-school/{schoolId}")
    public ResponseEntity<List<Student>> getStudentWithSchool(@PathVariable("schoolId") Integer schoolId) {
        return ResponseEntity.ok(studentService.getStudentWithSchool(schoolId));
    }
}
