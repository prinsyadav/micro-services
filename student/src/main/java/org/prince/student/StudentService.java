package org.prince.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

//    public Student getStudent(Long id) {
//        return studentRepo.findById(id).orElse(null);
//    }
//
//    public void deleteStudent(Long id) {
//        studentRepo.deleteById(id);
//    }
//
//    public Student updateStudent(Student student) {
//        return studentRepo.save(student);
//    }

    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public List<Student> getStudentWithSchool(Integer schoolId) {
        return studentRepo.findBySchoolId(schoolId);
    }

//    public void deleteAllStudents() {
//        studentRepo.deleteAll();
//    }
}
