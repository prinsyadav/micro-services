package org.prince.school;

import lombok.RequiredArgsConstructor;
import org.prince.school.client.StudentClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepo;
    private final StudentClient client;

    public School saveSchool(School school) {
         schoolRepo.save(school);
         return school;
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

    public Iterable<School> getAllSchool() {
        return schoolRepo.findAll();
    }

    public FullSchoolResponse getSchoolWithStudents(Integer schoolId) {
       var school = schoolRepo.findById(schoolId)
               .orElse(
                          School.builder()
                                 .name("School not found")
                                 .email("School not found")
                                 .build()
               );
       var students = client.findAllStudentsBySchool(schoolId);
       return FullSchoolResponse.builder()
               .name(school.getName())
               .email(school.getEmail())
               .students(students)
               .build();
    }

//    public void deleteAllStudents() {
//        studentRepo.deleteAll();
//    }
}
