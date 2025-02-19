package org.prince.school.client;

import org.prince.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${school.students-url}" )
public interface StudentClient {

    @GetMapping("/with-school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable("schoolId") Integer schoolId);
}
